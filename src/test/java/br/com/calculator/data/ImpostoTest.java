package br.com.calculator.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.calculator.data.domain.Imposto;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ImpostoTest {

    @Test
    @DisplayName("Deve criar um objeto Imposto com o valor devido e sem erro")
    void criar_imposto_com_valor_devido() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        Imposto imposto = new Imposto(valorDevido);

        assertEquals(valorDevido, imposto.getValorDevido());
        assertNull(imposto.getError());
    }

    @Test
    @DisplayName("Deve criar um objeto Imposto com o valor devido e com erro")
    void criar_imposto_com_valor_devido_e_erro() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        String error = "Erro ao calcular o imposto";
        Imposto imposto = new Imposto(valorDevido, error);

        assertEquals(valorDevido, imposto.getValorDevido());
        assertEquals(error, imposto.getError());
    }

    @Test
    @DisplayName("Deve testar o hashCode e equals")
    void testar_hashCode_e_equals() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        Imposto imposto1 = new Imposto(valorDevido);
        Imposto imposto2 = new Imposto(valorDevido);

        assertEquals(imposto1, imposto2);
        assertEquals(imposto1.hashCode(), imposto2.hashCode());
    }

    @Test
    @DisplayName("Deve testar o hashCode e equals com objetos diferentes")
    void testar_hashCode_e_equals_com_objetos_diferentes() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        BigDecimal valorDevido2 = new BigDecimal("10.00");
        Imposto imposto1 = new Imposto(valorDevido);
        Imposto imposto2 = new Imposto(valorDevido2);

        assertNotEquals(imposto1, imposto2);
        assertNotEquals(imposto1.hashCode(), imposto2.hashCode());
    }

    @Test
    @DisplayName("Deve testar o toString")
    void testar_toString() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        Imposto imposto = new Imposto(valorDevido);

        assertEquals("Imposto(valorDevido=100.00, error=null)", imposto.toString());
    }   

    @Test
    @DisplayName("Deve testar o of")
    void testar_of() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        Imposto imposto = Imposto.of();
        imposto.setValorDevido(valorDevido);

        assertEquals(valorDevido, imposto.getValorDevido());
        assertNull(imposto.getError());
    }

    @Test
    @DisplayName("Deve testar o builder")
    void testar_builder() {
        BigDecimal valorDevido = new BigDecimal("100.00");
        Imposto imposto = Imposto.builder()
            .valorDevido(valorDevido)
            .build();

        assertEquals(valorDevido, imposto.getValorDevido());
        assertNull(imposto.getError());
    }
}