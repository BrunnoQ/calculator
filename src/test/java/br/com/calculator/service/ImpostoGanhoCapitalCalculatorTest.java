package br.com.calculator.service;

import br.com.calculator.rules.implementations.RegrasGanhoCapitalAcoesImpl;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import br.com.calculator.service.implementations.ImpostoGanhoCapitalCalculatorImpl;
import br.com.calculator.service.interfaces.IImpostoGanhoCapitalCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static br.com.calculator.cenarios.ImpostoGanhoCapitalCalculatorCenarios.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpostoGanhoCapitalCalculatorTest {

    IImpostoGanhoCapitalCalculator calculator;
    IRegrasGanhoCapitalAcoes regras;

    @BeforeEach
    void init(){
        regras = RegrasGanhoCapitalAcoesImpl.of();
        calculator = ImpostoGanhoCapitalCalculatorImpl.of(regras);
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 1, com sucesso.")
    void deve_calcular_imposto_cenario1_sucesso(){
        assertEquals(IMPOSTOS_CENARIO1,calculator.calcularImposto(OPERACOES_CENARIO1));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 2, com sucesso.")
    void deve_calcular_imposto_cenario2_sucesso(){
        assertEquals(IMPOSTOS_CENARIO2,calculator.calcularImposto(OPERACOES_CENARIO2));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 3, com sucesso.")
    void deve_calcular_imposto_cenario3_sucesso(){
        assertEquals(IMPOSTOS_CENARIO3,calculator.calcularImposto(OPERACOES_CENARIO3));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 4, com sucesso.")
    void deve_calcular_imposto_cenario4_sucesso(){
        assertEquals(IMPOSTOS_CENARIO4,calculator.calcularImposto(OPERACOES_CENARIO4));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 5, com sucesso.")
    void deve_calcular_imposto_cenario5_sucesso(){
        assertEquals(IMPOSTOS_CENARIO5,calculator.calcularImposto(OPERACOES_CENARIO5));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 6, com sucesso.")
    void deve_calcular_imposto_cenario6_sucesso(){
        assertEquals(IMPOSTOS_CENARIO6,calculator.calcularImposto(OPERACOES_CENARIO6));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 7, com sucesso.")
    void deve_calcular_imposto_cenario7_sucesso(){
        assertEquals(IMPOSTOS_CENARIO7,calculator.calcularImposto(OPERACOES_CENARIO7));
    }

    @Test
    @DisplayName("Deve calcular imposto para o cenário 8, com sucesso.")
    void deve_calcular_imposto_cenario8_sucesso(){
        assertEquals(IMPOSTOS_CENARIO8,calculator.calcularImposto(OPERACOES_CENARIO8));
    }

    @Test
    @DisplayName("Não deve realizar nenhum calculo para operações que só contenham VENDA.")
    void nao_deve_calcular_imposto_cenario9_sucesso(){
        assertEquals(IMPOSTOS_CENARIO9,calculator.calcularImposto(OPERACOES_CENARIO9));
    }

    @Test
    @DisplayName("Não deve realizar nenhum calculo para operações que possuam ações VENDIDAS MAIOR QUE COMPRADAS.")
    void nao_deve_calcular_imposto_cenario10_sucesso(){
        assertEquals(IMPOSTOS_CENARIO10,calculator.calcularImposto(OPERACOES_CENARIO10));
    }

    @Test
    @DisplayName("Deve calcular imposto para lucro milionário.")
    void deve_calcular_imposto_cenario11_sucesso(){
        assertEquals(IMPOSTOS_CENARIO11,calculator.calcularImposto(OPERACOES_CENARIO11));
    }

    @Test
    @DisplayName("Deve calcular imposto e exibir mensagem de erro quando vender ações a mais do que possui.")
    void deve_calcular_imposto_e_exibir_mensagem_de_erro_sucesso(){
        assertEquals(IMPOSTOS_CENARIO12,calculator.calcularImposto(OPERACOES_CENARIO12));
    }

    @Test
    @DisplayName("Deve calcular imposto e exibir mensagem de erro quando vender ações a mais do que possui 2.")
    void deve_calcular_imposto_e_exibir_mensagem_de_erro_sucesso_(){
        assertEquals(IMPOSTOS_CENARIO13,calculator.calcularImposto(OPERACOES_CENARIO13));
    }

}
