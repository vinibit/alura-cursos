package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.builder.Item;
import alura.curso.designpatterns1.builder.NotaFiscal;
import alura.curso.designpatterns1.builder.NotaFiscalBuilder;
import alura.curso.designpatterns1.observer.EmailSender;
import alura.curso.designpatterns1.observer.NotaFiscalDAO;

public class TesteDeAcoesParaNotaFiscal {

	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.adcionaAcao(new EmailSender()); 
		builder.adcionaAcao(new NotaFiscalDAO());
		
		NotaFiscal notaFiscal = builder.paraEmpresa("Bit Co.")
				.deCNPJ("123.456.789/0001-10")
				.acrescenta(new Item("item 1", 100.0))
                .acrescenta(new Item("item 2", 200.0))
                .acrescenta(new Item("item 3", 300.0))
				.build();
		
		System.out.println(notaFiscal.getValorBruto());
	}

}
