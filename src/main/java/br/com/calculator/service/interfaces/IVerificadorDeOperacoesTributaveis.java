package br.com.calculator.service.interfaces;

import java.math.BigDecimal;
import br.com.calculator.data.domain.Operacao;

public interface IVerificadorDeOperacoesTributaveis {
    boolean isOperacaoTributavel(Operacao operacao, BigDecimal precoMedioPonderado, BigDecimal patrimonioAcumulado);
}