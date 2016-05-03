package alura.curso.designpatterns1.strategy.client;

import alura.curso.designpatterns1.model.imposto.Orcamento;
import alura.curso.designpatterns1.strategy.Imposto;

/**
 * 
 * Crie todo o mecanismo para flexibilizar a criação de diferentes estratégias de impostos. 
 * Crie a interface Imposto, e as estratégias ICMS e ISS. O ISS deve ser 6% do valor do orçamento, e o ICMS deve ser 5% do valor do orçamento mais 
 * o valor fixo de R$ 50,00.
 * Crie a classe Orcamento, que tem como atributo um valor. Crie um construtor que recebe esse valor, e um getter para devolvê-lo.
 * Crie a classe CalculadorDeImposto, que recebe um Orcamento e um Imposto. 
 * Essa classe calcula o imposto usando a estratégia recebida e imprime o resultado na tela.
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
		System.out.println("Orçamento calculado em: " + calculo);
		return calculo;
	}
}
