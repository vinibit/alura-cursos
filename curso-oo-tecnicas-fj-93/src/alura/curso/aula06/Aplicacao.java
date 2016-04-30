package alura.curso.aula06;

import java.util.Calendar;

import alura.curso.aula01.BalancoEmpresa;
import alura.curso.aula01.Divida;
import alura.curso.aula02.CNPJ;
import alura.curso.aula03.Pagamento;
import alura.curso.aula05.Documento;

public class Aplicacao {

	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		bd.conectar("localhost", "usuario", "1234");
		
		BalancoEmpresa balancoEmpresa = new BalancoEmpresa(bd);
		
		Divida divida1 = new Divida();
		divida1.setCredor("Vini Bit Inc.");
		Documento documentoCredor1 = new CNPJ("99.999.999/9000-09");
		divida1.setDocumentoCredor(documentoCredor1);
		divida1.setTotal(1340);
		
		Divida divida2 = new Divida();
		divida2.setCredor("Papaco Inc.");
		divida2.setDocumentoCredor(new CNPJ("00.000.000/0001-00"));
		divida2.setTotal(2350);
		
		balancoEmpresa.registraDivida(divida1);
		balancoEmpresa.registraDivida(divida2);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setPagador("Vini Bit Inc.");
		pagamento.setCnpjPagador(documentoCredor1);
		pagamento.setValor(1340);
		pagamento.setData(Calendar.getInstance());
		
		balancoEmpresa.pagaDivida(documentoCredor1, pagamento);
		
		bd.desconectar();
	}

}
