package alura.curso.designpatterns1.strategy;

import alura.curso.designpatterns1.model.orcamento.Orcamento;

/**
 * Crie o imposto que se chama ICCC, que retorna 5% do valor total 
 * caso o orçamento seja menor do que R$ 1000,00 reais, 7% caso o valor esteja entre R$ 1000 e R$ 3000,00 
 * com os limites inclusos, ou 8% mais 30 reais, caso o valor esteja acima de R$ 3000,00.
 * @author Vini
 *
 */
public class ICCC extends Imposto {

	public ICCC() {
		super();
	}
	
	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		double calculo = 0;
		if (orcamento.getValor() < 1000) 
			calculo = orcamento.getValor() * 0.05;
		else if (orcamento.getValor() <= 3000) 
			calculo = orcamento.getValor() * 0.07;
		else  
			calculo = orcamento.getValor() * 0.08 + 30;
		return calculo + calculoDoOutroImposto(orcamento);
	}

}
