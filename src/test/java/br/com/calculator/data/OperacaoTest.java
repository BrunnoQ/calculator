package br.com.calculator.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OperacaoTest {

    @Test
    @DisplayName("Deve criar um objeto Operacao com os valores corretos")
    void criar_operacao_com_valores_corretos() {
        TipoOperacao tipoOperacao = TipoOperacao.BUY;
        BigDecimal precoUnitario = new BigDecimal("10.00");
        int quantidade = 5;

        Operacao operacao = new Operacao(tipoOperacao, precoUnitario, quantidade);

        assertEquals(tipoOperacao, operacao.getTipoOperacao());
        assertEquals(precoUnitario, operacao.getPrecoUnitario());
        assertEquals(quantidade, operacao.getQuantidade());
    }

    @Test
    @DisplayName("Deve criar um objeto Operacao com o tipo de operação especificado")
    void criar_operacao_com_tipo_operacao_especificado() {
        TipoOperacao tipoOperacao = TipoOperacao.SELL;

        Operacao operacao = new Operacao(tipoOperacao);
        operacao.setPrecoUnitario(BigDecimal.ZERO);

        assertEquals(tipoOperacao, operacao.getTipoOperacao());
        assertNotNull(operacao.getPrecoUnitario());
        assertEquals(0, operacao.getQuantidade());
    }

    @Test
    @DisplayName("Deve criar um objeto Operacao com o tipo de operação especificado e o preço unitário")
    void criar_operacao_com_tipo_operacao_especificado_e_preco_unitario() {
        TipoOperacao tipoOperacao = TipoOperacao.SELL;
        BigDecimal precoUnitario = new BigDecimal("10.00");

        Operacao operacao = Operacao.builder()
            .tipoOperacao(tipoOperacao)
            .precoUnitario(precoUnitario)
            .build();
        operacao.setQuantidade(5);

        assertEquals(tipoOperacao, operacao.getTipoOperacao());
        assertEquals(precoUnitario, operacao.getPrecoUnitario());
        assertEquals(5, operacao.getQuantidade());
    }

    @Test
    @DisplayName("Deve testar o hashCode e equals")
    void testar_hashCode_e_equals() {
        TipoOperacao tipoOperacao = TipoOperacao.BUY;
        BigDecimal precoUnitario = new BigDecimal("10.00");
        int quantidade = 5;

        Operacao operacao1 = new Operacao(tipoOperacao, precoUnitario, quantidade);
        Operacao operacao2 = new Operacao(tipoOperacao, precoUnitario, quantidade);

        assertEquals(operacao1, operacao2);
        assertEquals(operacao1.hashCode(), operacao2.hashCode());
    }
}