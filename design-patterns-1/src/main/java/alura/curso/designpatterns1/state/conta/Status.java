package alura.curso.designpatterns1.state.conta;

public interface Status {
	void saque(double saque, Conta conta);
	void deposito(double deposito, Conta conta);
}
