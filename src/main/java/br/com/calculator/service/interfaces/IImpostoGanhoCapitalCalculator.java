package br.com.calculator.service.interfaces;

import br.com.calculator.data.domain.Imposto;
import br.com.calculator.data.domain.Operacao;
import java.util.List;

public interface IImpostoGanhoCapitalCalculator {
    List<Imposto> calcularImposto (List<Operacao> operacoes);
}
