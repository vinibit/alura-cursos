package alura.curso.designpatterns1.decorator;

import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

public class ImpostoMuitoAlto extends Imposto {
	
	public ImpostoMuitoAlto() {
		super();
	}
	
	public ImpostoMuitoAlto(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.2 + calculoDoOutroImposto(orcamento);
	}

}
