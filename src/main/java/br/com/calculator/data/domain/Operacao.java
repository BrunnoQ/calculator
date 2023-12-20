package br.com.calculator.data.domain;

import br.com.calculator.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents an operation in the calculator.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Operacao {
    private TipoOperacao tipoOperacao;
    
    /**
     * Constructs a new Operacao object with the specified TipoOperacao.
     * 
     * @param tipoOperacao the type of operation
     */
    public Operacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    private BigDecimal precoUnitario;
    private int quantidade;
}
