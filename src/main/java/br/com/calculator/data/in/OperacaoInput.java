package br.com.calculator.data.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * Represents an input for an operation in the calculator.
 */
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class OperacaoInput {
    @JsonProperty("operation")
    private String tipoOperacao;
    @JsonProperty("unit-cost")
    private double precoUnitario;
    @JsonProperty("quantity")
    private int quantidade;
}
