package alura.curso.designpatterns1.chainofresponsability.desconto;

import alura.curso.designpatterns1.model.desconto.Orcamento;

public class SemDesconto implements Desconto {
	
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	public void setProximo(Desconto proximo) {
		throw new UnsupportedOperationException();
	}

}
