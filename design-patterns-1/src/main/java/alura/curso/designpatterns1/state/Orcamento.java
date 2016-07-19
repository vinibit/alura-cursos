package alura.curso.designpatterns1.state;

public class Orcamento {
	protected double valor;
	protected EstadoDeUmOrcamento estadoAtual = new EmAprovacao();
	
	public Orcamento() {
	}
	
	public Orcamento(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}

	public void aprova() {
		estadoAtual.aprova(this);
	}

	public void reprova() {
		estadoAtual.reprova(this);
	}

	public void finaliza() {
		estadoAtual.finaliza(this);
	}

	protected void desconta(double desconto) {
		this.valor -= valor * desconto;
	}
}
