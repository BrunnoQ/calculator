package br.com.calculator.utils.converters;

import static br.com.calculator.cenarios.OperacaoConverterCenarios.OPERACAO_COMPRA_INPUT_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.OPERACOES_INPUT_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.OPERACAO_COMPRA_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.OPERACOES_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.IMPOSTO_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.IMPOSTO_OUTPUT_ARREDONDADO_VALIDO;
import static br.com.calculator.cenarios.OperacaoConverterCenarios.IMPOSTO_OUTPUT_EMPTY;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.in.OperacaoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OperacaoConverterTest {

    @Test
    @DisplayName("Deve realizar conversao de OperacaoInput para Operacao.")
    void converter_input_to_domain_sucesso() {
        assertEquals(OPERACAO_COMPRA_VALIDO, OperacaoConverter.inputToDomain(OPERACAO_COMPRA_INPUT_VALIDO));
    }

    @Test
    @DisplayName("Deve retornar nulo quando OperacaoInput for nulo.")
    void converter_input_to_domain_falha() {
         assertNull(OperacaoConverter.inputToDomain((OperacaoInput) null));
    }

    @Test
    @DisplayName("Deve realizar conversao de lista de OperacaoInputs para lista de Operacao.")
    void converter_lisOfInput_to_listOfDomain_sucesso() {
        assertEquals(OPERACOES_VALIDO, OperacaoConverter.inputToDomain(OPERACOES_INPUT_VALIDO));
    }

    @Test
    @DisplayName("Deve retornar nulo quando lista OperacaoInput for nula.")
    void converter_lisOfInput_to_listOfDomain_falha() {
        assertNull(OperacaoConverter.inputToDomain((List<OperacaoInput>) null));
    }

    @Test
    @DisplayName("Deve retornar nulo quando lista OperacaoInput estiver vazia.")
    void converter_lisOfInput_to_listOfDomain_empty_falha() {
        List<OperacaoInput> operacaoInputs = new ArrayList<>();
        assertNull(OperacaoConverter.inputToDomain(operacaoInputs));
    }

    @Test
    @DisplayName("Deve realizar conversao de Imposto para ImpostoOutput.")
    void converter_domainToOutput_sucesso() {
        assertEquals(IMPOSTO_OUTPUT_ARREDONDADO_VALIDO, OperacaoConverter.domainToOutput(IMPOSTO_VALIDO));
    }

    @Test
    @DisplayName("Deve realizar conversao de Imposto nulo para ImpostoOutput vazio.")
    void converter_domainToOutput_empty() {
        assertEquals(IMPOSTO_OUTPUT_EMPTY, OperacaoConverter.domainToOutput((Imposto) null));
    }

}
