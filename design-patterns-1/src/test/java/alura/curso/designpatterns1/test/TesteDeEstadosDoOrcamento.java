package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.state.Orcamento;

public class TesteDeEstadosDoOrcamento {
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(500.0);
		
		orcamento.aplicaDescontoExtra();
		orcamento.aprova();
		orcamento.aplicaDescontoExtra();
		orcamento.finaliza();
		
		System.out.println(orcamento.getValor());
	}
}
