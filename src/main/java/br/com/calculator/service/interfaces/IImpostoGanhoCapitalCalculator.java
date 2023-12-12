package br.com.calculator.service.interfaces;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import java.util.List;

/**
 * This interface represents a calculator for calculating taxes on capital gains.
 */
public interface IImpostoGanhoCapitalCalculator {
    /**
     * Calculates the taxes on capital gains based on the given list of operations.
     *
     * @param operacoes The list of operations for which the taxes need to be calculated.
     * @return The list of taxes calculated for each operation.
     */
    List<Imposto> calcularImposto(List<Operacao> operacoes);
}
