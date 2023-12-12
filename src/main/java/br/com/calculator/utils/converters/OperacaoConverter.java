package br.com.calculator.utils.converters;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import br.com.calculator.enums.TipoOperacao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * The OperacaoConverter class provides utility methods for converting between different representations of Operacao objects.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OperacaoConverter {

    /**
     * Converts a OperacaoInput object to a Operacao object.
     *
     * @param operacaoInput the OperacaoInput object to be converted
     * @return the Operacao object
     */
    public static Operacao inputToDomain(final OperacaoInput operacaoInput) {

        if (operacaoInput == null) {
            return null;
        }

        return Operacao.builder()
                .precoUnitario(BigDecimal.valueOf(operacaoInput.getPrecoUnitario()))
                .quantidade(operacaoInput.getQuantidade())
                .tipoOperacao(TipoOperacao.valueOf(operacaoInput.getTipoOperacao().toUpperCase()))
                .build();
    }

    /**
     * Converts a list of OperacaoInput objects to a list of Operacao objects.
     *
     * @param operacaoInputs the list of OperacaoInput objects to be converted
     * @return the list of Operacao objects
     */
    public static List<Operacao> inputToDomain(final List<OperacaoInput> operacaoInputs) {

        if (operacaoInputs == null || operacaoInputs.isEmpty()) {
            return null;
        }

        return operacaoInputs.stream().filter(Objects::nonNull)
                .map(OperacaoConverter::inputToDomain).collect(Collectors.toList());
    }

    /**
     * Converts a Operacao object to a ImpostoOutput object.
     *
     * @param operacaoOutput the Operacao object to be converted
     * @return the ImpostoOutput object
     */
    public static ImpostoOutput domainToOutput(final Imposto operacaoOutput) {

        if (operacaoOutput == null){
            return ImpostoOutput.of();
        }

        return new ImpostoOutput(operacaoOutput.getValorDevido() != null ? operacaoOutput.getValorDevido()
                .setScale(2, RoundingMode.HALF_EVEN) : null,
                operacaoOutput.getError());
    }

    /**
     * Converts a list of Operacao objects to a list of ImpostoOutput objects.
     *
     * @param impostos the list of Operacao objects to be converted
     * @return the list of ImpostoOutput objects
     */
    public static List<ImpostoOutput> domainToOutput(final List<Imposto> impostos) {
        return impostos.stream().filter(Objects::nonNull)
                .map(OperacaoConverter::domainToOutput).collect(Collectors.toList());
    }

}
