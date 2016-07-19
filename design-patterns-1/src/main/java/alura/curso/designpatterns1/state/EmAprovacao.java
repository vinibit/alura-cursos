package alura.curso.designpatterns1.state;

public class EmAprovacao implements EstadoDeUmOrcamento {
	private boolean descontoAplicado = false;

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (descontoAplicado) throw new RuntimeException("Desconto j� aplicado!");
		orcamento.desconta(0.05);
		descontoAplicado = true;
	}

	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.estadoAtual = new Aprovado();
	}

	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.estadoAtual = new Reprovado();
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Or�amento em aprova��o n�o podem ir para finalizado diretamente");
	}

}
