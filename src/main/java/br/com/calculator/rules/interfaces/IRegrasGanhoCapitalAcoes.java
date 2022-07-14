package br.com.calculator.rules.interfaces;

import br.com.calculator.data.domain.Operacao;
import java.math.BigDecimal;

public interface IRegrasGanhoCapitalAcoes {

    BigDecimal calcularValorOperacao(final BigDecimal precoUnitario,final int quantidade);

    BigDecimal calcularValorOperacao(final Operacao operacao);

    BigDecimal calcularLucro(final BigDecimal precoMedioPonderado, final Operacao operacao);

    BigDecimal tributarRendimento (final BigDecimal valorLucro, final double aliquota);

    boolean isOperacaoTributavel(final Operacao operacao, final BigDecimal precoMedioPonderado, BigDecimal patrimonioAcumulado);

    int somarTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeCompra);

    int subtrairTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeVenda);

    BigDecimal calcularPrecoMedioPonderado(final int quantidadeAcoesAtual, final BigDecimal mediaPonderadaAtual,
                                                 final Operacao operacaoDeCompra);

}
