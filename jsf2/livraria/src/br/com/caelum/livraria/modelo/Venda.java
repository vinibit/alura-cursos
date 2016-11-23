package br.com.caelum.livraria.modelo;

public class Venda {

	private Livro livro;
	private Integer quantidade;

	public Venda(Livro livro, Integer quantidade) {
		super();
		this.livro = livro;
		this.quantidade = quantidade;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return livro.toString();
	}
}
