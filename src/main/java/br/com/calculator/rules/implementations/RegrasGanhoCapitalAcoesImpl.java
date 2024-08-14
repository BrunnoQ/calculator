package br.com.calculator.rules.implementations;

import br.com.calculator.data.domain.Operacao;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import br.com.calculator.service.interfaces.ICalculadoraDeValores;
import br.com.calculator.service.interfaces.IManipuladorDeAcoes;
import br.com.calculator.service.interfaces.IVerificadorDeOperacoesTributaveis;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@RequiredArgsConstructor(staticName = "of")
public class RegrasGanhoCapitalAcoesImpl implements IRegrasGanhoCapitalAcoes {

    private final ICalculadoraDeValores calculadoraDeValores;
    private final IVerificadorDeOperacoesTributaveis verificadorDeOperacoesTributaveis;
    private final IManipuladorDeAcoes manipuladorDeAcoes;

    @Override
    public BigDecimal calcularValorOperacao(final BigDecimal precoUnitario, final int quantidade) {
        return calculadoraDeValores.calcularValorOperacao(precoUnitario, quantidade);
    }

    @Override
    public BigDecimal calcularValorOperacao(final Operacao operacao) {
        return calculadoraDeValores.calcularValorOperacao(operacao);
    }

    @Override
    public BigDecimal calcularLucro(BigDecimal precoMedioPonderado, Operacao operacao) {
        return calculadoraDeValores.calcularLucro(precoMedioPonderado, operacao);
    }

    @Override
    public BigDecimal tributarRendimento(BigDecimal valorLucro, double aliquota) {
        return calculadoraDeValores.tributarRendimento(valorLucro, aliquota);
    }

    @Override
    public boolean isOperacaoTributavel(final Operacao operacao, BigDecimal precoMedioPonderado, BigDecimal patrimonioAcumulado) {
        return verificadorDeOperacoesTributaveis.isOperacaoTributavel(operacao, precoMedioPonderado, patrimonioAcumulado);
    }

    @Override
    public int somarTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeCompra) {
        return manipuladorDeAcoes.somarTotalAcoes(quantidadeAtualAcoes, operacaoDeCompra);
    }

    @Override
    public int subtrairTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeVenda) {
        return manipuladorDeAcoes.subtrairTotalAcoes(quantidadeAtualAcoes, operacaoDeVenda);
    }

    @Override
    public BigDecimal calcularPrecoMedioPonderado(int quantidadeAcoesAtual, BigDecimal mediaPonderadaAtual, Operacao operacaoDeCompra) {
        return calculadoraDeValores.calcularPrecoMedioPonderado(quantidadeAcoesAtual, mediaPonderadaAtual, operacaoDeCompra);
    }
}