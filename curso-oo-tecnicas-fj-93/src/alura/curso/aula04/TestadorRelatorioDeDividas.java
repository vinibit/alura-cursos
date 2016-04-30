package alura.curso.aula04;

import java.text.NumberFormat;
import java.util.Locale;

import alura.curso.aula01.Divida;
import alura.curso.aula02.CNPJ;

public class TestadorRelatorioDeDividas {
	
	public static void main(String[] args) {
		Divida divida = new Divida();
		divida.setCredor("Vini");
		divida.setDocumentoCredor(new CNPJ("99.999.999/9000-09"));
		divida.setTotal(1340);
		
		RelatorioDeDivida relatorioDeDivida = new RelatorioDeDivida(divida);
		
		NumberFormat formatadorBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		relatorioDeDivida.geraRelatorio(formatadorBR);
		
		NumberFormat formatadorEUA = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		relatorioDeDivida.geraRelatorio(formatadorEUA);
	}
	
}
