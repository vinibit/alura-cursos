package alura.curso.designpatterns1.chainofresponsability.desconto;

import alura.curso.designpatterns1.model.orcamento.Orcamento;

public interface Desconto {
	double desconta(Orcamento orcamento);

	void setProximo(Desconto proximo);
}
