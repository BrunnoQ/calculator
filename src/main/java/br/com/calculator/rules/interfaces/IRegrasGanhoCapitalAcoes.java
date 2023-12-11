package br.com.calculator.rules.interfaces;

import br.com.calculator.data.domain.Operacao;
import java.math.BigDecimal;

/**
 * This interface defines the rules for calculating capital gains on stock transactions.
 */
public interface IRegrasGanhoCapitalAcoes {

    /**
     * Calculates the value of an operation based on the unit price and quantity.
     *
     * @param precoUnitario the unit price of the operation
     * @param quantidade the quantity of the operation
     * @return the calculated value of the operation
     */
    BigDecimal calcularValorOperacao(final BigDecimal precoUnitario,final int quantidade);

    /**
     * Calculates the value of an operation based on the operation object.
     *
     * @param operacao the operation object
     * @return the calculated value of the operation
     */
    BigDecimal calcularValorOperacao(final Operacao operacao);

    /**
     * Calculates the profit based on the weighted average price and the operation object.
     *
     * @param precoMedioPonderado the weighted average price
     * @param operacao the operation object
     * @return the calculated profit
     */
    BigDecimal calcularLucro(final BigDecimal precoMedioPonderado, final Operacao operacao);

    /**
     * Calculates the tax on the profit based on the profit value and the tax rate.
     *
     * @param valorLucro the profit value
     * @param aliquota the tax rate
     * @return the calculated tax on the profit
     */
    BigDecimal tributarRendimento (final BigDecimal valorLucro, final double aliquota);

    /**
     * Checks if an operation is taxable based on the operation object, the weighted average price, and the accumulated wealth.
     *
     * @param operacao the operation object
     * @param precoMedioPonderado the weighted average price
     * @param patrimonioAcumulado the accumulated wealth
     * @return true if the operation is taxable, false otherwise
     */
    boolean isOperacaoTributavel(final Operacao operacao, final BigDecimal precoMedioPonderado, BigDecimal patrimonioAcumulado);

    /**
     * Adds the quantity of a purchase operation to the current total quantity of shares.
     *
     * @param quantidadeAtualAcoes the current total quantity of shares
     * @param operacaoDeCompra the purchase operation
     * @return the updated total quantity of shares
     */
    int somarTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeCompra);

    /**
     * Subtracts the quantity of a sale operation from the current total quantity of shares.
     *
     * @param quantidadeAtualAcoes the current total quantity of shares
     * @param operacaoDeVenda the sale operation
     * @return the updated total quantity of shares
     */
    int subtrairTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeVenda);

    /**
     * Calculates the weighted average price based on the current quantity of shares, the current weighted average price,
     * and a purchase operation.
     *
     * @param quantidadeAcoesAtual the current quantity of shares
     * @param mediaPonderadaAtual the current weighted average price
     * @param operacaoDeCompra the purchase operation
     * @return the calculated weighted average price
     */
    BigDecimal calcularPrecoMedioPonderado(final int quantidadeAcoesAtual, final BigDecimal mediaPonderadaAtual,
                                                 final Operacao operacaoDeCompra);

}
