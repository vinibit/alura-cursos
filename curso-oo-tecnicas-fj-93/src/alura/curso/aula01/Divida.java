package alura.curso.aula01;

import alura.curso.aula03.Pagamento;
import alura.curso.aula05.Documento;
import alura.curso.aula05.Pagamentos;

public class Divida {
	private double total;
	private String credor;
	private Documento documentoCredor;
	private Pagamentos pagamentos = new Pagamentos();
	
	public void registra(Pagamento pagamento) {
		this.pagamentos.registra(pagamento);
	}
	
	public double valorAPagar() {
		return this.total - this.pagamentos.getValorPago();
	}

	public Documento getDocumentoCredor() {
		return this.documentoCredor;
	}

	public void setDocumentoCredor(Documento documentoCredor) {
		this.documentoCredor = documentoCredor;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCredor() {
		return credor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}
	
}
