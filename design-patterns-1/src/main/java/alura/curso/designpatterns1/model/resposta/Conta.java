package alura.curso.designpatterns1.model.resposta;

import java.util.Calendar;

public class Conta {
	private String titular;
	private double saldo;

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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Calendar getDataAbertura() {
		// TODO Auto-generated method stub
		return null;
	}

}
