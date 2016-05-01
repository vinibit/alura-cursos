package alura.curso.designpatterns1.chainofresponsability.desconto;

import alura.curso.designpatterns1.model.desconto.Orcamento;

public class DescontoPorMaisDeCincoItems implements Desconto {
	private Desconto proximo;

	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		}
		return proximo.desconta(orcamento);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
