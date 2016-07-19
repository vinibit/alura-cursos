package alura.curso.designpatterns1.templatemethod;

import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

public class ICPP extends ImpostoTemplate {
	
	public ICPP() {
		super();
	}
	
	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public double calculaTaxacaoPadrao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 ;
	}

	@Override
	public double calculaTaxacaoSuperior(Orcamento orcamento) {
		return orcamento.getValor() * 0.07 ;
	}

	@Override
	public boolean deveUsarTaxacaoSuperior(Orcamento orcamento) {
		return orcamento.getValor() > 500.0;
	}
	
}
