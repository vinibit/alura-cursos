package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.chainofresponsability.desconto.Desconto;
import alura.curso.designpatterns1.chainofresponsability.desconto.DescontoPorMaisDeCincoItems;
import alura.curso.designpatterns1.chainofresponsability.desconto.DescontoPorMaisQueQuinhentosReais;
import alura.curso.designpatterns1.chainofresponsability.desconto.DescontoPorVendaCasada;
import alura.curso.designpatterns1.chainofresponsability.desconto.SemDesconto;
import alura.curso.designpatterns1.model.desconto.Item;
import alura.curso.designpatterns1.model.desconto.Orcamento;

public class TesteDeDescontos {
	public static void main(String[] args) {
		Desconto descontoPorMaisDeCincoItems = new DescontoPorMaisDeCincoItems();
		Desconto descontoPorMaisQueQuinhentosReais = new DescontoPorMaisQueQuinhentosReais();
		DescontoPorVendaCasada descontoPorVendaCasada = new DescontoPorVendaCasada();
		Desconto semDesconto = new SemDesconto();
		
		descontoPorMaisDeCincoItems.setProximo(descontoPorMaisQueQuinhentosReais);
		descontoPorMaisQueQuinhentosReais.setProximo(descontoPorVendaCasada);
		descontoPorVendaCasada.setProximo(semDesconto);
		
		Orcamento orcamento = new Orcamento(400.0);
		orcamento.adicionaItem(new Item("LAPIS", 20.0));
		orcamento.adicionaItem(new Item("CANETA", 10.0));
		orcamento.adicionaItem(new Item("BORRACHA", 10.0));
		
		double desconto = descontoPorMaisDeCincoItems.desconta(orcamento);
		System.out.println(desconto);
	}
}

