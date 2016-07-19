package alura.curso.designpatterns1.state.conta;

public class Postivo implements Status {
	
	@Override
	public void saque(double saque, Conta conta) {
		conta.saldo -= saque;
		if (!conta.saldoPositivo()) conta.status = new Negativo();
	}
	
	@Override
	public void deposito(double deposito, Conta conta) {
		conta.saldo += deposito * 0.98;
	}

}
