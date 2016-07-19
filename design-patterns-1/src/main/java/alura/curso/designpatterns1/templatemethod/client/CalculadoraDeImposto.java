package alura.curso.designpatterns1.templatemethod.client;

import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;
import alura.curso.designpatterns1.templatemethod.ICPP;

public class CalculadoraDeImposto {

	Orcamento orcamento;

	public CalculadoraDeImposto(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public double realizaCalculo(Imposto imposto) {
		double calculo = imposto.calcula(orcamento);
		System.out.println("Orçamento calculado em: " + calculo);
		return calculo;
	}
	
	public static void main(String[] args) {
		CalculadoraDeImposto calculadoraDeImposto = new CalculadoraDeImposto(new Orcamento(1000.0));
		calculadoraDeImposto.realizaCalculo(new ICPP());
	}
}
