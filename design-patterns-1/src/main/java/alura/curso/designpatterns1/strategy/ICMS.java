package alura.curso.designpatterns1.strategy;

import alura.curso.designpatterns1.model.orcamento.Orcamento;

public class ICMS extends Imposto {
	
	public ICMS() {
	}
	
	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50 + calculoDoOutroImposto(orcamento);
	}

}
