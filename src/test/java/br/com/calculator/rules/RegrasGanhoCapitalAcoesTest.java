package br.com.calculator.rules;

import br.com.calculator.rules.implementations.RegrasGanhoCapitalAcoesImpl;
import br.com.calculator.service.implementations.CalculadoraDeValoresImpl;
import br.com.calculator.service.implementations.ManipuladorDeAcoesImpl;
import br.com.calculator.service.implementations.VerificadorDeOperacoesTributaveisImpl;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.*;
import static br.com.calculator.cenarios.RegrasGanhoCapitalAcoesCenarios.VALOR_OPERACAO_ESPERADO;
import static br.com.calculator.constants.CalculatorConstants.ALIQUOTA_TRIBUTACAO;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
public class RegrasGanhoCapitalAcoesTest {

    static RegrasGanhoCapitalAcoesImpl regrasGanhoCapitalAcoes;
    static CalculadoraDeValoresImpl calculadoraDeValores;
    static VerificadorDeOperacoesTributaveisImpl verificadorDeOperacoesTributaveis;
    static ManipuladorDeAcoesImpl manipuladorDeAcoes;

    @BeforeAll
    static void init() {
        calculadoraDeValores = CalculadoraDeValoresImpl.of();
        verificadorDeOperacoesTributaveis =
                VerificadorDeOperacoesTributaveisImpl.of(calculadoraDeValores);
        manipuladorDeAcoes = ManipuladorDeAcoesImpl.of();
        regrasGanhoCapitalAcoes = RegrasGanhoCapitalAcoesImpl.of(calculadoraDeValores,
                verificadorDeOperacoesTributaveis, manipuladorDeAcoes);
    }

    @Test
    @DisplayName("Deve calcular o valor da operacao.")
    void calcular_valor_operacao_sucesso() {
        assertEquals(VALOR_OPERACAO_ESPERADO,
                regrasGanhoCapitalAcoes.calcularValorOperacao(OPERACAO_COMPRA_VALIDO));
    }

    @Test
    @DisplayName("Deve calcular o valor da operacao.")
    void calcular_imposto_sucesso() {
        assertEquals(BigDecimal.valueOf(200.00d).setScale(2), regrasGanhoCapitalAcoes
                .tributarRendimento(BigDecimal.valueOf(1000.00d), ALIQUOTA_TRIBUTACAO));
    }

    @Test
    @DisplayName("Deve verificar que o valor não é tributável.")
    void verificar_valor_operacao_tributavel_compra_sucesso() {
        assertFalse(regrasGanhoCapitalAcoes.isOperacaoTributavel(OPERACAO_COMPRA_VALIDO,
                PRECO_MEDIO_TRIBUTAVEL, BigDecimal.valueOf(-1000.00d)));
    }

    @Test
    @DisplayName("Deve verificar que a operacao é tributável.")
    void verificar_valor_operacao_tributavel_sucesso() {
        assertTrue(regrasGanhoCapitalAcoes.isOperacaoTributavel(OPERACAO_VENDA_TRIBUTAVEL_VALIDO,
                PRECO_MEDIO_PONDERADO, BigDecimal.valueOf(1000.00d)));
    }

    @Test
    @DisplayName("Deve calcular a quantidade total de ações na compra.")
    void calcular_quantidade_total_acoes_compra_sucesso() {
        assertEquals(10002, regrasGanhoCapitalAcoes.somarTotalAcoes(2, OPERACAO_COMPRA_VALIDO));
    }

    @Test
    @DisplayName("Deve manter a quantidade total de ações, quando o calculo de compra for realizado com operação de venda.")
    void calcular_quantidade_total_acoes_venda_sucesso() {
        assertEquals(2,
                regrasGanhoCapitalAcoes.somarTotalAcoes(2, OPERACAO_VENDA_TRIBUTAVEL_VALIDO));
    }

    @Test
    @DisplayName("Deve calcular a quantidade total de ações após operação de venda.")
    void calcular_quantidade_total_acoes_apos_venda_sucesso() {
        assertEquals(0, regrasGanhoCapitalAcoes.subtrairTotalAcoes(30000,
                OPERACAO_VENDA_TRIBUTAVEL_VALIDO));
    }

    @Test
    @DisplayName("Deve manter a quantidade total de ações, quando o calculo de venda for realizado com operação de compra.")
    void calcular_quantidade_total_acoes_apos_venda_com_compra_sucesso() {
        assertEquals(30000,
                regrasGanhoCapitalAcoes.subtrairTotalAcoes(30000, OPERACAO_COMPRA_VALIDO));
    }

    @Test
    @DisplayName("Deve calcular o preço médio ponderado das compras.")
    void calcular_preco_medio_ponderado_sucesso() {
        assertEquals(BigDecimal.valueOf(15.00d).setScale(2),
                regrasGanhoCapitalAcoes.calcularPrecoMedioPonderado(
                        OPERACAO_COMPRA_VALIDO_2.getQuantidade(),
                        OPERACAO_COMPRA_VALIDO_2.getPrecoUnitario(), OPERACAO_COMPRA_VALIDO_3));
    }

}
