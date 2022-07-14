package br.com.calculator.data.domain;

import br.com.calculator.enums.TipoOperacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Operacao {
    private TipoOperacao tipoOperacao;
    private BigDecimal precoUnitario;
    private int quantidade;
}
