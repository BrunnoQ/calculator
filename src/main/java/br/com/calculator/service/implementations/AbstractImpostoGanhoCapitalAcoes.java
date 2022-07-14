package br.com.calculator.service.implementations;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import java.math.BigDecimal;
import java.util.List;
import static br.com.calculator.constants.CalculatorConstants.ZERO_B;
import static br.com.calculator.constants.CalculatorConstants.ZERO_I;


public abstract class AbstractImpostoGanhoCapitalAcoes {

    protected Integer quantidadeDeAcoesAtual = ZERO_I;
    protected BigDecimal precoMedioPonderado = ZERO_B;
    protected BigDecimal valorLucro = ZERO_B;

    protected void inicializarContadoresDeCalculo(Operacao operacao) {
        precoMedioPonderado = operacao.getPrecoUnitario();
        quantidadeDeAcoesAtual = operacao.getQuantidade();
        valorLucro = ZERO_B;
    }

    protected abstract void aplicarRegrasCompra(final Operacao operacao, final List<Imposto> impostos);

    protected abstract void aplicarRegrasVenda(final Operacao operacao, final List<Imposto> impostos);
}
