package br.com.calculator.service.implementations;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import br.com.calculator.service.interfaces.IImpostoGanhoCapitalCalculator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static br.com.calculator.constants.CalculatorConstants.ALIQUOTA_TRIBUTACAO;
import static br.com.calculator.constants.CalculatorConstants.VALOR_IMPOSTO_DEFAULT;

/**
 * This class represents an implementation of the ImpostoGanhoCapitalCalculator interface.
 * It calculates the taxes on capital gains from stock transactions.
 */
@RequiredArgsConstructor(staticName = "of")
public class ImpostoGanhoCapitalCalculatorImpl extends AbstractImpostoGanhoCapitalAcoes
        implements IImpostoGanhoCapitalCalculator{

    @NonNull
    private IRegrasGanhoCapitalAcoes regraCalculo;
    private static final String ERROR_MESSAGE = "Can't sell more stocks than you have";
    private static final int ZERO = 0;

    @Override
    public List<Imposto> calcularImposto(List<Operacao> operacoes) {
        List<Imposto> impostos = new ArrayList<>();

        operacoes.forEach(operacao -> {
            aplicarRegras(operacao, impostos);
        });

        return impostos;
    }

    /**
     * This method applies the rules for calculating the taxes on capital gains from stock transactions.
     * @param operacao
     * @param impostos
     */
    private void aplicarRegras(Operacao operacao, List<Imposto> impostos) {
        if (operacao.getTipoOperacao().equals(TipoOperacao.BUY)) {
            aplicarRegrasCompra(operacao, impostos);
        } 
        
        if (operacao.getTipoOperacao().equals(TipoOperacao.SELL)) {
            aplicarRegrasVenda(operacao, impostos);
        }
    }

    protected void aplicarRegrasCompra(Operacao operacao, List<Imposto> impostos) {
        if (quantidadeDeAcoesAtual == ZERO) {
            inicializarContadoresDeCalculo(operacao);
        } else {
            calcularPrecoMedioPonderado(operacao);
            somarTotalAcoes(operacao);
        }
        impostos.add(criarImpostoDefault());
    }

    /**
     * This method calculates the weighted average price of the stock.
     * @param operacao
     */
    private void calcularPrecoMedioPonderado(Operacao operacao) {
        precoMedioPonderado = regraCalculo
                .calcularPrecoMedioPonderado(quantidadeDeAcoesAtual, precoMedioPonderado, operacao);
    }

    /**
     * This method calculates the total number of shares.
     * @param operacao
    */
    private void somarTotalAcoes(Operacao operacao) {
        quantidadeDeAcoesAtual = regraCalculo.somarTotalAcoes(quantidadeDeAcoesAtual, operacao);
    }

    /**
     * This method initializes the counters for calculating the taxes on capital gains from stock transactions.
     * @param operacao
     */
    private Imposto criarImpostoDefault() {
        return Imposto.builder().valorDevido(BigDecimal.valueOf(VALOR_IMPOSTO_DEFAULT)).build();
    }

    protected void aplicarRegrasVenda(Operacao operacao, List<Imposto> impostos) {
        if (quantidadeDeAcoesAtual > ZERO && regraCalculo.subtrairTotalAcoes(quantidadeDeAcoesAtual, operacao) >= ZERO) {
            calcularLucro(operacao);
            adicionarImposto(operacao, impostos);
            subtrairTotalAcoes(operacao);
        } else {
            impostos.add(criarImpostoErro());
        }
    }

    /**
     * This method calculates the profit from the sale of the stock.
     * @param operacao
    */
    private void calcularLucro(Operacao operacao) {
        valorLucro = valorLucro.add(regraCalculo.calcularLucro(precoMedioPonderado, operacao));
    }

    /**
     * This method adds the tax to the list of taxes.
     * @param operacao
     * @param impostos
     */
    private void adicionarImposto(Operacao operacao, List<Imposto> impostos) {
        if (regraCalculo.isOperacaoTributavel(operacao, precoMedioPonderado, valorLucro)) {
            impostos.add(criarImpostoTributavel());
        } else {
            impostos.add(criarImpostoDefault());
        }
    }

    /**
     * This method creates a tax object.
     * @return Imposto
     */
    private Imposto criarImpostoTributavel() {
        return Imposto.builder().valorDevido(regraCalculo
                .tributarRendimento(valorLucro, ALIQUOTA_TRIBUTACAO)).build();
    }

    /**
     * This method subtracts the total number of shares.
     * @param operacao
     */
    private void subtrairTotalAcoes(Operacao operacao) {
        quantidadeDeAcoesAtual = regraCalculo.subtrairTotalAcoes(quantidadeDeAcoesAtual, operacao);
    }

    private Imposto criarImpostoErro() {
        return Imposto.builder().error(ERROR_MESSAGE).build();
    }
}
