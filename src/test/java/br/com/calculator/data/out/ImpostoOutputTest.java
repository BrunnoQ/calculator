package br.com.calculator.data.out;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ImpostoOutputTest {

    @Test
    public void testEquals() {
        ImpostoOutput output1 = ImpostoOutput.builder()
                .valorDevido(new BigDecimal("10.00"))
                .build();

        ImpostoOutput output2 = ImpostoOutput.builder()
                .valorDevido(new BigDecimal("10.00"))
                .build();

        ImpostoOutput output3 = ImpostoOutput.builder()
                .valorDevido(new BigDecimal("20.00"))
                .build();

        Assertions.assertEquals(output1, output2); // Success case
        Assertions.assertNotEquals(output1, output3); // Failure case
    }

    @Test
    public void testHashCode() {
        ImpostoOutput output1 = ImpostoOutput.builder()
                .valorDevido(new BigDecimal("10.00"))
                .build();

        ImpostoOutput output2 = ImpostoOutput.builder()
                .valorDevido(new BigDecimal("10.00"))
                .build();

        Assertions.assertEquals(output1.hashCode(), output2.hashCode()); // Success case
    }

    @Test
    public void testBuilder() {
        BigDecimal valorDevido = new BigDecimal("10.00");
        ImpostoOutput output = ImpostoOutput.builder()
                .valorDevido(valorDevido)
                .build();

        Assertions.assertEquals(valorDevido, output.getValorDevido()); // Success case
    }
}