package alura.curso.designpatterns1.templatemethod;

import alura.curso.designpatterns1.model.orcamento.Item;
import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

public class IKCV extends ImpostoTemplate {

	public IKCV() {
		super();
	}
	
	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public double calculaTaxacaoPadrao(Orcamento orcamento) {
		return orcamento.getValor() % 0.06 ;
	}

	@Override
	public double calculaTaxacaoSuperior(Orcamento orcamento) {
		return orcamento.getValor() % 0.10 ;
	}

	@Override
	public boolean deveUsarTaxacaoSuperior(Orcamento orcamento) {
		return orcamento.getValor() > 500.0 && temItemComValorSuperior(100.0, orcamento);
	}

	private boolean temItemComValorSuperior(double valor, Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > valor) {
				return true;
			}
		}
		return false;
	}

}
