package alura.curso.designpatterns1.state.conta;

public class Negativo implements Status {
	
	@Override
	public void saque(double saque, Conta conta) {
		throw new RuntimeException("Sua conta est� no vermelho. N�o � poss�vel sacar!");
	}
	
	@Override
	public void deposito(double deposito, Conta conta) {
		conta.saldo += deposito * 0.95;
		if (!conta.saldoPositivo()) conta.status = new Postivo();
	}

}
