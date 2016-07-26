package alura.curso.designpatterns1.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import alura.curso.designpatterns1.observer.NotaFiscalObserver;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String CNPJ;

	private List<Item> todosItens = new ArrayList<>();
	private double valorBruto;
	private double impostos;
	private String observacoes;
	private LocalDate data;
	
	private List<NotaFiscalObserver> todasAcoes = new ArrayList<>();

	public NotaFiscalBuilder() {
		this.data = LocalDate.now();
	}
	
	public NotaFiscalBuilder(NotaFiscalObserver... acoes) {
		for (NotaFiscalObserver acao : acoes) {
			adcionaAcao(acao);
		}
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder deCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	/*
	 * public NotaFiscalBuilder naDataAtual() { 
	 *    this.data = LocalDate.now();
	 *    return this; 
	 * }
	 */

	public NotaFiscalBuilder naData(LocalDate data) {
		this.data = data;
		return this;
	}

	public NotaFiscalBuilder acrescenta(Item item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NotaFiscal build() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, CNPJ, valorBruto, impostos, data, observacoes, todosItens);
		
		for (NotaFiscalObserver acao : todasAcoes) {
			acao.executa(notaFiscal);
		}
		
		return notaFiscal;
	}
	
	public void adcionaAcao(NotaFiscalObserver acao) {
		this.todasAcoes.add(acao);
	}

}
