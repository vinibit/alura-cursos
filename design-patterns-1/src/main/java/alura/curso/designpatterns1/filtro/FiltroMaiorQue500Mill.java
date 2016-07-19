package alura.curso.designpatterns1.filtro;

import java.util.ArrayList;
import java.util.List;

import alura.curso.designpatterns1.model.resposta.Conta;

public class FiltroMaiorQue500Mill extends Filtro {

	public FiltroMaiorQue500Mill() {
		super();
	}

	public FiltroMaiorQue500Mill(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta c : contas) {
			if (c.getSaldo() > 500000)
				filtrada.add(c);
		}

		filtrada.addAll(aplicaProximoFiltro(contas));
		return filtrada;
	}

}
