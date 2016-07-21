package alura.curso.designpatterns1.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalBuilder {

	private String razaoSocial;
	private String CNPJ;
	
	private List<Item> todosItens = new ArrayList<>();
	private double valorBruto;
	private double impostos;
	private String observacoes;
	private LocalDate data;

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

	public NotaFiscalBuilder naDataAtual() {
		this.data = LocalDate.now();
		return this;
	}

	public NotaFiscalBuilder acrescenta(Item item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}
	
	public NotaFiscal build() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, CNPJ, 
				valorBruto, impostos, data, observacoes, todosItens);
		return notaFiscal;
	}

}
