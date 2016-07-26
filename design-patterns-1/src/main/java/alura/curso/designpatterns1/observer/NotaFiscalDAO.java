package alura.curso.designpatterns1.observer;

import alura.curso.designpatterns1.builder.NotaFiscal;

public class NotaFiscalDAO implements NotaFiscalObserver {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("salvando no banco");
	}
}
