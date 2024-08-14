package br.com.calculator.cenarios;


import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import java.math.BigDecimal;
import java.util.List;
import static br.com.calculator.utils.converters.OperacaoConverter.inputToDomain;
import static br.com.calculator.utils.json.JsonUtil.jsonToList;


@SuppressWarnings("all")
public class ImpostoGanhoCapitalCalculatorCenarios {

        public final static List<Operacao> OPERACOES_CENARIO1 =
                        inputToDomain(jsonToList("[{\"operation\":\"buy\""
                                        + ", \"unit-cost\":10.00, \"quantity\": 100},{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}"
                                        + ",{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 50}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO1 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)));

        public final static List<Operacao> OPERACOES_CENARIO2 =
                        inputToDomain(jsonToList("[{\"operation\":\"buy\", "
                                        + "\"unit-cost\":10.00, \"quantity\": 10000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO2 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(10000.00d).setScale(2)),
                                        new Imposto(BigDecimal.valueOf(0.00d)));

        public final static List<Operacao> OPERACOES_CENARIO3 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":5.00, \"quantity\": 5000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 3000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO3 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(1000.00d).setScale(2)));

        public final static List<Operacao> OPERACOES_CENARIO4 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"buy\", \"unit-cost\":25.00, \"quantity\": 5000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 10000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO4 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)));

        public final static List<Operacao> OPERACOES_CENARIO5 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"buy\", \"unit-cost\":25.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 5000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO5 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(10000.00d).setScale(3)));

        public final static List<Operacao> OPERACOES_CENARIO6 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":2.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000},{\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 1000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO6 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(3000.00d).setScale(2)));

        public final static List<Operacao> OPERACOES_CENARIO7 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":2.00, \"quantity\": 5000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 2000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":25.00, \"quantity\": 1000},{\"operation\":\"buy\", \"unit-cost\":20.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":15.00, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":30.00, \"quantity\": 4350},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":30.00, \"quantity\": 650}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO7 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(3000.00d).setScale(2)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(3700.00d).setScale(2)),
                                        new Imposto(BigDecimal.valueOf(0.00d)));

        public final static List<Operacao> OPERACOES_CENARIO8 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000},{\"operation\":\"buy\", \"unit-cost\":20.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO8 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(80000.00d).setScale(2)),
                                        new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(60000.00d).setScale(2)));

        public final static List<Operacao> OPERACOES_CENARIO9 = inputToDomain(jsonToList(
                        "[{\"operation\":\"sell\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000},{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 10000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO9 = List.of(
                        Imposto.builder().error("Can't sell more stocks than you have").build(),
                        Imposto.builder().error("Can't sell more stocks than you have").build(),
                        Imposto.builder().error("Can't sell more stocks than you have").build(),
                        Imposto.builder().error("Can't sell more stocks than you have").build());

        public final static List<Operacao> OPERACOES_CENARIO10 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":50.00, \"quantity\": 20000}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO10 = List.of(
                        new Imposto(BigDecimal.valueOf(0.00d)),
                        Imposto.builder().error("Can't sell more stocks than you have").build());

        public final static List<Operacao> OPERACOES_CENARIO11 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":3.55, \"quantity\": 100000},"
                                        + "{\"operation\":\"sell\", \"unit-cost\":7.15, \"quantity\": 55554},{\"operation\":\"sell\", \"unit-cost\":23.97, \"quantity\": 44446}]"));

        public final static List<Imposto> IMPOSTOS_CENARIO11 =
                        List.of(new Imposto(BigDecimal.valueOf(0.00d)),
                                        new Imposto(BigDecimal.valueOf(39998.880d).setScale(3)),
                                        new Imposto(BigDecimal.valueOf(221516.344d)));

        public final static List<Operacao> OPERACOES_CENARIO12 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 11000}]"));
        public final static List<Imposto> IMPOSTOS_CENARIO12 = List.of(
                        new Imposto(BigDecimal.valueOf(0.00d)),
                        Imposto.builder().error("Can't sell more stocks than you have").build());

        public final static List<Operacao> OPERACOES_CENARIO13 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 6000},{\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 5000}]"));
        public final static List<Imposto> IMPOSTOS_CENARIO13 = List.of(
                        new Imposto(BigDecimal.valueOf(0.00d)),
                        new Imposto(BigDecimal.valueOf(12000.00d).setScale(2)),
                        Imposto.builder().error("Can't sell more stocks than you have").build());

        public final static List<Operacao> OPERACOES_CENARIO14 = inputToDomain(jsonToList(
                        "[{\"operation\":\"buy\", \"unit-cost\":10, \"quantity\": 10000}, {\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 6000},{\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 5000},{\"operation\":\"sell\", \"unit-cost\":20, \"quantity\": 5000}]"));


}
