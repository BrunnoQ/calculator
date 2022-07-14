package br.com.calculator.data.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ImpostoOutput {

    public ImpostoOutput(BigDecimal valorDevido){
        this.valorDevido = valorDevido;
        this.error = null;
    }

    @JsonProperty("tax")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal valorDevido;
    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
}
