package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.ICCC;
import alura.curso.designpatterns1.strategy.client.CalculadoraDeImposto;

public class TesteParaCalculoDeImposto {
	
	public void testaCalculoDeICCC() {
		Orcamento orcamento1 = new Orcamento(600.0);
		CalculadoraDeImposto calculadora1 = new CalculadoraDeImposto(orcamento1);
		calculadora1.realizaCalculo(new ICCC());
		
		Orcamento orcamento2 = new Orcamento(2100.0);
		CalculadoraDeImposto calculadora2 = new CalculadoraDeImposto(orcamento2);
		calculadora2.realizaCalculo(new ICCC());
		
		Orcamento orcamento3 = new Orcamento(5600.0);
		CalculadoraDeImposto calculadora3 = new CalculadoraDeImposto(orcamento3);
		calculadora3.realizaCalculo(new ICCC());
	}
	
	public static void main(String[] args) {
		TesteParaCalculoDeImposto teste = new TesteParaCalculoDeImposto();
		teste.testaCalculoDeICCC();
	}
	
}
