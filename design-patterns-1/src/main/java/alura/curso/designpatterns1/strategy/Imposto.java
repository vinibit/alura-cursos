package alura.curso.designpatterns1.strategy;

import alura.curso.designpatterns1.model.imposto.Orcamento;

public interface Imposto {
	double calcula(Orcamento orcamento);
}
