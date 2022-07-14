package br.com.calculator.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum TipoOperacao {
    BUY("buy"),
    SELL("sell");
    private String descricao;
}
