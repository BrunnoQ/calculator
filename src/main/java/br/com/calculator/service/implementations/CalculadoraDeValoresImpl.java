package br.com.calculator.service.implementations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.service.interfaces.ICalculadoraDeValores;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class CalculadoraDeValoresImpl implements ICalculadoraDeValores {

    @Override
    public BigDecimal calcularValorOperacao(final BigDecimal precoUnitario, final int quantidade) {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public BigDecimal calcularValorOperacao(final Operacao operacao) {
        return this.calcularValorOperacao(operacao.getPrecoUnitario(), operacao.getQuantidade());
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
    public BigDecimal calcularPrecoMedioPonderado(int quantidadeAcoesAtual, BigDecimal mediaPonderadaAtual, Operacao operacaoDeCompra) {
        BigDecimal montanteAtual = this.calcularValorOperacao(mediaPonderadaAtual, quantidadeAcoesAtual);
        BigDecimal valorOperacaoAtual = this.calcularValorOperacao(operacaoDeCompra);
        long totalGlobalQuantidadeAcoes = operacaoDeCompra.getQuantidade() + quantidadeAcoesAtual;
        return montanteAtual.add(valorOperacaoAtual).divide(BigDecimal.valueOf(totalGlobalQuantidadeAcoes), 2, RoundingMode.HALF_EVEN);
    }
}