package alura.curso.designpatterns1.filtro;

import java.util.Collections;
import java.util.List;

import alura.curso.designpatterns1.model.resposta.Conta;

public abstract class Filtro {
	private Filtro outroFiltro;
	
	public Filtro() {
	}
	
	public Filtro(Filtro outroFiltro) {
		this.outroFiltro = outroFiltro;
	}
	
	public abstract List<Conta> filtra(List<Conta> contas);
	
	protected List<Conta> aplicaProximoFiltro(List<Conta> contas) {
		if (outroFiltro == null) return Collections.emptyList();
		return outroFiltro.filtra(contas);
	}
}
