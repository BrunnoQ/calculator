package br.com.calculator.utils.json;

import static br.com.calculator.cenarios.JsonUtilCenarios.JSON_OPERATION_VALIDO;
import static br.com.calculator.cenarios.JsonUtilCenarios.INPUT_LIST_VALIDA;
import static br.com.calculator.cenarios.JsonUtilCenarios.OUTPUT_LIST_VALIDA;
import static br.com.calculator.cenarios.JsonUtilCenarios.JSON_IMPOSTO_VALIDO;
import static br.com.calculator.utils.json.JsonUtil.jsonToList;
import static br.com.calculator.utils.json.JsonUtil.listToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsonUtilTest {

    @Test
    @DisplayName("Deve realizar conversao de json para lista de operacoes, quando json for valido.")
    void converter_json_to_list_sucesso() {
        assertEquals(INPUT_LIST_VALIDA, jsonToList(JSON_OPERATION_VALIDO));
    }

    @Test
    @DisplayName("Deve realizar conversao de lista de impostos para json.")
    void converter_list_to_json_sucesso() {
        assertEquals(JSON_IMPOSTO_VALIDO, listToJson(OUTPUT_LIST_VALIDA));
    }

}
