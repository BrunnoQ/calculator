package br.com.calculator.cenarios;

import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import java.math.BigDecimal;
import java.util.List;

public class JsonUtilCenarios {

    public final static String JSON_OPERATION_VALIDO = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000}," +
            "{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000}]";
    public final static List<OperacaoInput> INPUT_LIST_VALIDA = construirListaValida();
    public final static String JSON_IMPOSTO_VALIDO = "[{\"tax\":0.01},{\"tax\":10000.01}]";
    public final static List<ImpostoOutput> OUTPUT_LIST_VALIDA = List.of(new ImpostoOutput(BigDecimal.valueOf(0.01d)),
            new ImpostoOutput(BigDecimal.valueOf(10000.01d)));


    private static List<OperacaoInput> construirListaValida(){
        return List.of(OperacaoInput.builder()
                .tipoOperacao("buy")
                .quantidade(10000)
                .precoUnitario(10.00d)
                .build(),
                OperacaoInput.builder()
                        .tipoOperacao("sell")
                        .quantidade(5000)
                        .precoUnitario(20.00d)
                        .build());
    }
}
