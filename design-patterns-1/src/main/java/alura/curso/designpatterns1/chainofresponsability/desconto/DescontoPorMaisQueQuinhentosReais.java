package alura.curso.designpatterns1.chainofresponsability.desconto;

import alura.curso.designpatterns1.model.desconto.Orcamento;

public class DescontoPorMaisQueQuinhentosReais implements Desconto {
	private Desconto proximo;
	
	public double desconta(Orcamento orcamento) {
		if (orcamento.getValor() > 500.0) {
			return orcamento.getValor() * 0.07;
		}
		return proximo.desconta(orcamento);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
