package br.com.calculator.data.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an input for an operation in the calculator.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OperacaoInput {
    @JsonProperty("operation")
    private String tipoOperacao;
    @JsonProperty("unit-cost")
    private double precoUnitario;
    @JsonProperty("quantity")
    private int quantidade;
}
