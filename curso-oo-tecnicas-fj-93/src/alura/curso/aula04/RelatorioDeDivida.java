package alura.curso.aula04;

import java.text.NumberFormat;

import alura.curso.aula01.Divida;

public class RelatorioDeDivida {
	
	private Divida divida;
	
	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}
	
	public void geraRelatorio(NumberFormat formatador) {
		System.out.println("Credor: " + divida.getCredor());
		System.out.println("CNPJ: " + divida.getDocumentoCredor());
		System.out.println("Valor a pagar: " + formatador.format(divida.valorAPagar()));
		System.out.println("Total: " + formatador.format(divida.getTotal()));
	}
	
}
