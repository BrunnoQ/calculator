package br.com.calculator.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * Represents an Imposto (tax) object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Imposto {

    /**
     * Constructs an Imposto object with the specified valorDevido.
     *
     * @param valorDevido the valorDevido of the Imposto
     */
    public Imposto (BigDecimal valorDevido){
        this.valorDevido = valorDevido;
        this.error = null;
    }

    private BigDecimal valorDevido;
    private String error;
}
