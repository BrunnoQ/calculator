package br.com.calculator.service.interfaces;

import java.math.BigDecimal;
import br.com.calculator.data.domain.Operacao;

public interface ICalculadoraDeValores {

    BigDecimal calcularValorOperacao(BigDecimal precoUnitario, int quantidade);
    BigDecimal calcularValorOperacao(Operacao operacao);
    BigDecimal calcularLucro(BigDecimal precoMedioPonderado, Operacao operacao);
    BigDecimal tributarRendimento(BigDecimal valorLucro, double aliquota);
    BigDecimal calcularPrecoMedioPonderado(int quantidadeAcoesAtual, BigDecimal mediaPonderadaAtual, Operacao operacaoDeCompra);
    
}