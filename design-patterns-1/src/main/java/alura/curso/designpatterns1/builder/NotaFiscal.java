package alura.curso.designpatterns1.builder;

import java.time.LocalDate;
import java.util.List;

public class NotaFiscal {
	String razaoSocial; 
	String CNPJ; 
	double valorBruto; 
	double impostos; 
	LocalDate dataEmissao; 
	String observacoes;
	
	List<Item> itens;

	public NotaFiscal(String razaoSocial, String CNPJ, double valorBruto, double impostos, LocalDate dataEmissao,
			String observacoes, List<Item> itens) {
		this.razaoSocial = razaoSocial;
		this.CNPJ = CNPJ;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.dataEmissao = dataEmissao;
		this.observacoes = observacoes;
		this.itens = itens;
	}
}
