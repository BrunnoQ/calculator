package br.com.calculator.cenarios;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import br.com.calculator.enums.TipoOperacao;
import java.math.BigDecimal;
import java.util.List;

public final class OperacaoConverterCenarios {


    public final static BigDecimal PRECO_MEDIO_TRIBUTAVEL = BigDecimal.valueOf(10000);
    public final static BigDecimal PRECO_MEDIO_PONDERADO = BigDecimal.valueOf(5.00);

    public final static OperacaoInput OPERACAO_COMPRA_INPUT_VALIDO = OperacaoInput.builder()
            .tipoOperacao("buy")
            .quantidade(10000)
            .precoUnitario(10.00d)
            .build();

    public final static Operacao OPERACAO_COMPRA_VALIDO = Operacao.builder()
            .tipoOperacao(TipoOperacao.BUY)
            .quantidade(10000)
            .precoUnitario(BigDecimal.valueOf(10.00d))
            .build();

    public final static Operacao OPERACAO_COMPRA_VALIDO_2 = Operacao.builder()
            .tipoOperacao(TipoOperacao.BUY)
            .quantidade(5)
            .precoUnitario(BigDecimal.valueOf(20.00d))
            .build();

    public final static Operacao OPERACAO_COMPRA_VALIDO_3 = Operacao.builder()
            .tipoOperacao(TipoOperacao.BUY)
            .quantidade(5)
            .precoUnitario(BigDecimal.valueOf(10.00d))
            .build();

    public final static Operacao OPERACAO_VENDA_TRIBUTAVEL_VALIDO = Operacao.builder()
            .tipoOperacao(TipoOperacao.SELL)
            .quantidade(30000)
            .precoUnitario(BigDecimal.valueOf(10.00d))
            .build();

    public final static Imposto IMPOSTO_VALIDO = Imposto.builder()
            .valorDevido(BigDecimal.valueOf(10.758d))
            .build();

    public final static ImpostoOutput IMPOSTO_OUTPUT_ARREDONDADO_VALIDO = ImpostoOutput.builder()
            .valorDevido(BigDecimal.valueOf(10.76d))
            .build();

    public final static ImpostoOutput IMPOSTO_OUTPUT_EMPTY = ImpostoOutput.builder()
            .build();

    public final static List<OperacaoInput> OPERACOES_INPUT_VALIDO = List.of(OperacaoInput.builder()
            .tipoOperacao("buy")
            .quantidade(10000)
            .precoUnitario(10.00d)
            .build(),
            OperacaoInput.builder()
                    .tipoOperacao("sell")
                    .quantidade(5000)
                    .precoUnitario(20.00d)
                    .build());

    public final static List<Operacao> OPERACOES_VALIDO = List.of(Operacao.builder()
                    .tipoOperacao(TipoOperacao.BUY)
                    .quantidade(10000)
                    .precoUnitario(BigDecimal.valueOf(10.00d))
                    .build(),
            Operacao.builder()
                    .tipoOperacao(TipoOperacao.SELL)
                    .quantidade(5000)
                    .precoUnitario(BigDecimal.valueOf(20.00d))
                    .build());


}
