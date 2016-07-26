package alura.curso.designpatterns1.observer;

import alura.curso.designpatterns1.builder.NotaFiscal;

public interface NotaFiscalObserver {
	void executa(NotaFiscal notaFiscal);
}
