package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.decorator.ImpostoMuitoAlto;
import alura.curso.designpatterns1.model.orcamento.Orcamento;
import alura.curso.designpatterns1.strategy.ICMS;
import alura.curso.designpatterns1.strategy.ISS;
import alura.curso.designpatterns1.strategy.Imposto;

public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(500.0);
		
		Imposto impostoComplexo = new ISS(new ICMS());
		double valor1 = impostoComplexo.calcula(orcamento);
		System.out.println(valor1);
		
		Imposto impostoMuitoAlto = new ImpostoMuitoAlto(new ICMS());
		double valor2 = impostoMuitoAlto.calcula(orcamento);
		System.out.println(valor2);
	}

}
