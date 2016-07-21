package alura.curso.designpatterns1.builder;

public class Item {
	String descricao;
	double valor;

	public Item(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getValor() {
		return valor;
	}

}
