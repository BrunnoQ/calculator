package br.com.calculator.rules.implementations;

import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static br.com.calculator.constants.CalculatorConstants.VALOR_TRIBUTAVEL;
import static br.com.calculator.constants.CalculatorConstants.ZERO;

@RequiredArgsConstructor(staticName = "of")
public class RegrasGanhoCapitalAcoesImpl implements IRegrasGanhoCapitalAcoes {

    @Override
    public BigDecimal calcularValorOperacao(final BigDecimal precoUnitario, final int quantidade) {
        return precoUnitario
                .multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public BigDecimal calcularValorOperacao(final Operacao operacao) {
        return this.calcularValorOperacao(operacao.getPrecoUnitario(),
                operacao.getQuantidade());
    }

    @Override
    public BigDecimal calcularLucro(BigDecimal precoMedioPonderado, Operacao operacao) {
        return operacao.getPrecoUnitario().subtract(precoMedioPonderado)
                .multiply(BigDecimal.valueOf(operacao.getQuantidade()));
    }

    @Override
    public BigDecimal tributarRendimento(BigDecimal valorLucro, double aliquota) {
        return valorLucro.multiply(BigDecimal.valueOf(aliquota));
    }

    @Override
    public boolean isOperacaoTributavel(final Operacao operacao, BigDecimal precoMedioPonderado,
                                        BigDecimal patrimonioAcumulado){

        if (operacao.getTipoOperacao().equals(TipoOperacao.BUY))
            return false;

        BigDecimal valorOperacao = this.calcularValorOperacao(operacao);

        BigDecimal valorTributavel = BigDecimal.valueOf(VALOR_TRIBUTAVEL);
        BigDecimal zero = BigDecimal.valueOf(ZERO);
        
        boolean isValorOperacaoTributavel = valorOperacao.compareTo(valorTributavel) > 0;
        boolean isPrecoUnitarioMaiorQuePrecoMedio = operacao.getPrecoUnitario().compareTo(precoMedioPonderado) > 0;
        boolean isLucroPositivo = this.calcularLucro(precoMedioPonderado, operacao).compareTo(zero) > 0;
        boolean isPatrimonioAcumuladoPositivo = patrimonioAcumulado.compareTo(zero) > 0;
        
        return isValorOperacaoTributavel 
                && isPrecoUnitarioMaiorQuePrecoMedio 
                && isLucroPositivo 
                && isPatrimonioAcumuladoPositivo;
    }

    @Override
    public int somarTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeCompra) {
        return operacaoDeCompra.getTipoOperacao().equals(TipoOperacao.BUY) ? quantidadeAtualAcoes
                + operacaoDeCompra.getQuantidade() : quantidadeAtualAcoes;
    }

    @Override
    public int subtrairTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeVenda) {
        return operacaoDeVenda.getTipoOperacao().equals(TipoOperacao.SELL) ? quantidadeAtualAcoes
                - operacaoDeVenda.getQuantidade() : quantidadeAtualAcoes;
    }

    @Override
    public BigDecimal calcularPrecoMedioPonderado(int quantidadeAcoesAtual,
        BigDecimal mediaPonderadaAtual, Operacao operacaoDeCompra) {

        BigDecimal montanteAtual = this.calcularValorOperacao(mediaPonderadaAtual,quantidadeAcoesAtual);
        BigDecimal valorOperacaoAtual = this.calcularValorOperacao(operacaoDeCompra);
        long totalGlobalQuantidadeAcoes = operacaoDeCompra.getQuantidade() + quantidadeAcoesAtual;
        return montanteAtual.add(valorOperacaoAtual).divide(BigDecimal.valueOf(totalGlobalQuantidadeAcoes),2, RoundingMode.HALF_EVEN);
    }
}
