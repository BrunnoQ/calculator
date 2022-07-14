package br.com.calculator.utils.json;

import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<OperacaoInput> jsonToList(String json) {
        try {
            return mapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException ("JSON inválido.");
        }
    }

    public static String listToJson(List<ImpostoOutput> impostos) {
        try {
            return mapper.writeValueAsString(impostos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException ("JSON inválido.");
        }
    }
}
