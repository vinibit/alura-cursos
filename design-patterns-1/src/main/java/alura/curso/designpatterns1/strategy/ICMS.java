package alura.curso.designpatterns1.strategy;

import alura.curso.designpatterns1.model.imposto.Orcamento;

public class ICMS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50;
	}

}
