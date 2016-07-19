package alura.curso.designpatterns1.strategy;

import alura.curso.designpatterns1.model.orcamento.Orcamento;

public class ISS extends Imposto {

	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

}
