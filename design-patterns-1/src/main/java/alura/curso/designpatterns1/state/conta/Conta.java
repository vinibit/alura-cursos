package alura.curso.designpatterns1.state.conta;

public class Conta {
	private String titular;
	protected double saldo;
	protected Status status;

	public Conta(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposita(double deposito) {
		status.deposito(deposito, this);
	}
	
	public void saca(double saque) {
		status.saque(saque, this);
	}
	
	protected boolean saldoPositivo() {
		return this.saldo >= 0;
	}

}
