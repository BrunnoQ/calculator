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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OperacaoConverter {

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

    public static List<Operacao> inputToDomain(final List<OperacaoInput> operacaoInputs) {

        if (operacaoInputs == null || operacaoInputs.isEmpty()) {
            return null;
        }

        return operacaoInputs.stream().filter(Objects::nonNull)
                .map(OperacaoConverter::inputToDomain).collect(Collectors.toList());
    }

    public static ImpostoOutput domainToOutput(final Imposto operacaoOutput) {

        if (operacaoOutput == null){
            return new ImpostoOutput();
        }

        return new ImpostoOutput(operacaoOutput.getValorDevido() != null ? operacaoOutput.getValorDevido()
                .setScale(2, RoundingMode.HALF_EVEN) : null,
                operacaoOutput.getError());
    }

    public static List<ImpostoOutput> domainToOutput(final List<Imposto> impostos) {
        return impostos.stream().filter(Objects::nonNull)
                .map(OperacaoConverter::domainToOutput).collect(Collectors.toList());
    }

}
