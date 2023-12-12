package br.com.calculator.service.implementations;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import java.math.BigDecimal;
import java.util.List;
import static br.com.calculator.constants.CalculatorConstants.ZERO_B;
import static br.com.calculator.constants.CalculatorConstants.ZERO_I;


/**
 * This abstract class represents the base implementation for calculating capital gain taxes on stock transactions.
 */
public abstract class AbstractImpostoGanhoCapitalAcoes {

    protected Integer quantidadeDeAcoesAtual = ZERO_I;
    protected BigDecimal precoMedioPonderado = ZERO_B;
    protected BigDecimal valorLucro = ZERO_B;

    /**
     * Initializes the calculation counters with the values from the given operation.
     *
     * @param operacao The operation to initialize the counters with.
     */
    protected void inicializarContadoresDeCalculo(Operacao operacao) {
        precoMedioPonderado = operacao.getPrecoUnitario();
        quantidadeDeAcoesAtual = operacao.getQuantidade();
        valorLucro = ZERO_B;
    }

    /**
     * Applies the purchase rules for the given operation and updates the list of taxes.
     *
     * @param operacao The purchase operation to apply the rules to.
     * @param impostos The list of taxes to update.
     */
    protected abstract void aplicarRegrasCompra(final Operacao operacao, final List<Imposto> impostos);

    /**
     * Applies the sale rules for the given operation and updates the list of taxes.
     *
     * @param operacao The sale operation to apply the rules to.
     * @param impostos The list of taxes to update.
     */
    protected abstract void aplicarRegrasVenda(final Operacao operacao, final List<Imposto> impostos);
}
