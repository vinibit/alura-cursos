package alura.curso.designpatterns1.templatemethod;

import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

public abstract class ImpostoTemplate extends Imposto {
	
	public ImpostoTemplate() {
		super();
	}
	
	public ImpostoTemplate(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		if (deveUsarTaxacaoSuperior(orcamento)) {
			return calculaTaxacaoSuperior(orcamento);
		} else {
			return calculaTaxacaoPadrao(orcamento);
		}
	}

	public abstract double calculaTaxacaoPadrao(Orcamento orcamento);

	public abstract double calculaTaxacaoSuperior(Orcamento orcamento);

	public abstract boolean deveUsarTaxacaoSuperior(Orcamento orcamento);

}
