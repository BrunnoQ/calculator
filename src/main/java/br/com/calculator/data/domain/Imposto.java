package br.com.calculator.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Imposto {

    public Imposto (BigDecimal valorDevido){
        this.valorDevido = valorDevido;
        this.error = null;
    }

    private BigDecimal valorDevido;
    private String error;
}
