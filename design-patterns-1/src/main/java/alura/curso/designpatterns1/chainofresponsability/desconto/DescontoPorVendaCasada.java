package alura.curso.designpatterns1.chainofresponsability.desconto;

import alura.curso.designpatterns1.model.orcamento.Item;
import alura.curso.designpatterns1.model.orcamento.Orcamento;

public class DescontoPorVendaCasada implements Desconto {
	private Desconto proximo;

	public double desconta(Orcamento orcamento) {
		if (aconteceuVendaCasadaEm(orcamento)) {
			return orcamento.getValor() * 0.05;
		}
		return proximo.desconta(orcamento);
	}

	private boolean aconteceuVendaCasadaEm(Orcamento orcamento) {
		return existe("LAPIS", orcamento) && existe("CANETA", orcamento);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
	
    private boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

}
