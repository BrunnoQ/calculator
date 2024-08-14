package br.com.calculator.service.implementations;

import java.math.BigDecimal;
import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;
import br.com.calculator.service.interfaces.ICalculadoraDeValores;
import br.com.calculator.service.interfaces.IVerificadorDeOperacoesTributaveis;
import lombok.RequiredArgsConstructor;

import static br.com.calculator.constants.CalculatorConstants.VALOR_TRIBUTAVEL;
import static br.com.calculator.constants.CalculatorConstants.ZERO;

@RequiredArgsConstructor(staticName = "of")
public class VerificadorDeOperacoesTributaveisImpl implements IVerificadorDeOperacoesTributaveis {

    private final ICalculadoraDeValores calculadoraDeValores;

    @Override
    public boolean isOperacaoTributavel(final Operacao operacao, BigDecimal precoMedioPonderado, BigDecimal patrimonioAcumulado) {

        if (operacao.getTipoOperacao().equals(TipoOperacao.BUY))
            return false;

        BigDecimal valorOperacao = calculadoraDeValores.calcularValorOperacao(operacao);

        BigDecimal valorTributavel = BigDecimal.valueOf(VALOR_TRIBUTAVEL);
        BigDecimal zero = BigDecimal.valueOf(ZERO);

        boolean isValorOperacaoTributavel = valorOperacao.compareTo(valorTributavel) > 0;
        boolean isPrecoUnitarioMaiorQuePrecoMedio = operacao.getPrecoUnitario().compareTo(precoMedioPonderado) > 0;
        boolean isLucroPositivo = calculadoraDeValores.calcularLucro(precoMedioPonderado, operacao).compareTo(zero) > 0;
        boolean isPatrimonioAcumuladoPositivo = patrimonioAcumulado.compareTo(zero) > 0;

        return isValorOperacaoTributavel && isPrecoUnitarioMaiorQuePrecoMedio && isLucroPositivo && isPatrimonioAcumuladoPositivo;
    }
}