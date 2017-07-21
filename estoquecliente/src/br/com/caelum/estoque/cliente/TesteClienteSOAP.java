package br.com.caelum.estoque.cliente;

public class TesteClienteSOAP {
	public static void main(String[] args) {
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();
		
		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);
		
		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		
		ListaItens itens = cliente.todosOsItens(filtros);
		
		System.out.println("O serviço respondeu:" + itens.toString());
	}
}
