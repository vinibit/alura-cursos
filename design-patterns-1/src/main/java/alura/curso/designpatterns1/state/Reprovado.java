package alura.curso.designpatterns1.state;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento est� em estado de reprova��o, n�o pode aprovar agora!");
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� foi reprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual = new Finalizado();
	}

}
