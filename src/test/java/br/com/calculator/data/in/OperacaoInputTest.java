package br.com.calculator.data.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OperacaoInputTest {

    @Test
    @DisplayName("Deve criar um objeto OperacaoInput com os valores corretos")
    void criar_operacao_input_com_valores_corretos() {
        String tipoOperacao = "BUY";
        double precoUnitario = 10.00;
        int quantidade = 5;

        OperacaoInput operacaoInput = new OperacaoInput(tipoOperacao, precoUnitario, quantidade);

        assertEquals(tipoOperacao, operacaoInput.getTipoOperacao());
        assertEquals(precoUnitario, operacaoInput.getPrecoUnitario());
        assertEquals(quantidade, operacaoInput.getQuantidade());
    }

    @Test
    @DisplayName("Deve testar o equals e hashCode")
    void testar_equals_e_hashCode() {
        OperacaoInput operacaoInput1 = new OperacaoInput("BUY", 10.00, 5);
        OperacaoInput operacaoInput2 = new OperacaoInput("BUY", 10.00, 5);
        OperacaoInput operacaoInput3 = new OperacaoInput("SELL", 10.00, 5);

        assertEquals(operacaoInput1, operacaoInput2);
        assertEquals(operacaoInput1.hashCode(), operacaoInput2.hashCode());

        assertNotEquals(operacaoInput1, operacaoInput3);
        assertNotEquals(operacaoInput1.hashCode(), operacaoInput3.hashCode());
    }

    @Test
    @DisplayName("Deve serializar e deserializar corretamente o objeto OperacaoInput")
    void testar_serializacao_e_deserializacao() throws IOException {
        OperacaoInput operacaoInput = new OperacaoInput("BUY", 10.00, 5);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(operacaoInput);

        OperacaoInput deserializedOperacaoInput = objectMapper.readValue(json, OperacaoInput.class);

        assertEquals(operacaoInput, deserializedOperacaoInput);
    }
}