package br.com.calculator.service.implementations;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import br.com.calculator.service.interfaces.IImpostoGanhoCapitalCalculator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static br.com.calculator.constants.CalculatorConstants.ALIQUOTA_TRIBUTACAO;
import static br.com.calculator.constants.CalculatorConstants.VALOR_IMPOSTO_DEFAULT;

@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImpostoGanhoCapitalCalculatorImpl extends AbstractImpostoGanhoCapitalAcoes
        implements IImpostoGanhoCapitalCalculator{

    @NonNull
    private IRegrasGanhoCapitalAcoes regraCalculo;
    private List<Imposto> impostos;

    @Override
    public List<Imposto> calcularImposto(List<Operacao> operacoes) {

        impostos = new ArrayList<>();

        operacoes.forEach(operacao -> {
            aplicarRegrasCompra(operacao,impostos);
            aplicarRegrasVenda(operacao,impostos);
        });

        return impostos;
    }

    @Override
    protected void aplicarRegrasCompra(Operacao operacao, List<Imposto> impostos) {

        if (operacao != null && operacao.getTipoOperacao().equals(TipoOperacao.BUY)) {
            if (quantidadeDeAcoesAtual == 0) {

                inicializarContadoresDeCalculo(operacao);
            } else {

                precoMedioPonderado = regraCalculo
                        .calcularPrecoMedioPonderado(quantidadeDeAcoesAtual, precoMedioPonderado, operacao);
                quantidadeDeAcoesAtual = regraCalculo.somarTotalAcoes(quantidadeDeAcoesAtual, operacao);
            }
            impostos.add(Imposto.builder().valorDevido(BigDecimal.valueOf(VALOR_IMPOSTO_DEFAULT)).build());
        }

    }

    @Override
    protected void aplicarRegrasVenda(Operacao operacao, List<Imposto> impostos) {

        if (operacao != null && operacao.getTipoOperacao().equals(TipoOperacao.SELL) && quantidadeDeAcoesAtual > 0
                && regraCalculo.subtrairTotalAcoes(quantidadeDeAcoesAtual, operacao) >= 0) {

            valorLucro = valorLucro.add(regraCalculo.calcularLucro(precoMedioPonderado, operacao));

            if (regraCalculo.isOperacaoTributavel(operacao, precoMedioPonderado, valorLucro)) {
                impostos.add(Imposto.builder().valorDevido(regraCalculo
                        .tributarRendimento(valorLucro, ALIQUOTA_TRIBUTACAO)).build());

            } else {
                impostos.add(Imposto.builder().valorDevido(BigDecimal.valueOf(VALOR_IMPOSTO_DEFAULT)).build());
            }

            quantidadeDeAcoesAtual = regraCalculo.subtrairTotalAcoes(quantidadeDeAcoesAtual, operacao);

        } else if (operacao.getTipoOperacao().equals(TipoOperacao.SELL)){
            impostos.add(Imposto.builder().error("Can't sell more stocks than you have").build());
        }
    }
}
