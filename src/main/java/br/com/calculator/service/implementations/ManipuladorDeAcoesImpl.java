package br.com.calculator.service.implementations;

import br.com.calculator.data.domain.Operacao;
import br.com.calculator.enums.TipoOperacao;
import br.com.calculator.service.interfaces.IManipuladorDeAcoes;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class ManipuladorDeAcoesImpl implements IManipuladorDeAcoes {

    @Override
    public int somarTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeCompra) {
        return operacaoDeCompra.getTipoOperacao().equals(TipoOperacao.BUY)
                ? quantidadeAtualAcoes + operacaoDeCompra.getQuantidade()
                : quantidadeAtualAcoes;
    }

    @Override
    public int subtrairTotalAcoes(final int quantidadeAtualAcoes, final Operacao operacaoDeVenda) {
        return operacaoDeVenda.getTipoOperacao().equals(TipoOperacao.SELL)
                ? quantidadeAtualAcoes - operacaoDeVenda.getQuantidade()
                : quantidadeAtualAcoes;
    }
}
