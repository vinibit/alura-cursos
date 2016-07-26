package alura.curso.designpatterns1.observer;

import alura.curso.designpatterns1.builder.NotaFiscal;

public class Printer implements NotaFiscalObserver {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("imprimindo notaFiscal");
	}
}
