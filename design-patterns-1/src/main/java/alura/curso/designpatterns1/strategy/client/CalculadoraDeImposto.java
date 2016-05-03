package alura.curso.designpatterns1.strategy.client;

import alura.curso.designpatterns1.model.imposto.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

/**
 * 
 * Crie todo o mecanismo para flexibilizar a cria��o de diferentes estrat�gias de impostos. 
 * Crie a interface Imposto, e as estrat�gias ICMS e ISS. O ISS deve ser 6% do valor do or�amento, e o ICMS deve ser 5% do valor do or�amento mais 
 * o valor fixo de R$ 50,00.
 * Crie a classe Orcamento, que tem como atributo um valor. Crie um construtor que recebe esse valor, e um getter para devolv�-lo.
 * Crie a classe CalculadorDeImposto, que recebe um Orcamento e um Imposto. 
 * Essa classe calcula o imposto usando a estrat�gia recebida e imprime o resultado na tela.
 * 
 * @author Vini
 *
 */
public class CalculadoraDeImposto {
	
	Orcamento orcamento;
	
	public CalculadoraDeImposto(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	public double realizaCalculo(Imposto imposto) {
		double calculo = imposto.calcula(orcamento);
		System.out.println("Or�amento calculado em: " + calculo);
		return calculo;
	}
}
