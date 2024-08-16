package br.com.calculator.utils.json;

import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The JsonUtil class provides utility methods for converting between different representations of JSON objects.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Converts a JSON string to a list of OperacaoInput objects.
     *
     * @param json the JSON string to be converted
     * @return the list of OperacaoInput objects
     */
    public static List<OperacaoInput> jsonToList(String json) {
        try {
            return mapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException ("JSON inválido.");
        }
    }

    /**
     * Converts a list of ImpostoOutput objects to a JSON string.
     *
     * @param impostos the list of ImpostoOutput objects to be converted
     * @return the JSON string
     */
    public static String listToJson(List<ImpostoOutput> impostos) {
        try {
            return mapper.writeValueAsString(impostos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException ("JSON inválido.");
        }
    }

    
}
