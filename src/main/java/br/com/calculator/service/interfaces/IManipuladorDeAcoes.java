package br.com.calculator.service.interfaces;

import br.com.calculator.data.domain.Operacao;

public interface IManipuladorDeAcoes {
    int somarTotalAcoes(int quantidadeAtualAcoes, Operacao operacaoDeCompra);
    int subtrairTotalAcoes(int quantidadeAtualAcoes, Operacao operacaoDeVenda);
}