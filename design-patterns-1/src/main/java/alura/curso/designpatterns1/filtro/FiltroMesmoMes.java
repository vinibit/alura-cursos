package alura.curso.designpatterns1.filtro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import alura.curso.designpatterns1.model.resposta.Conta;

public class FiltroMesmoMes extends Filtro {

	public FiltroMesmoMes() {
	}

	public FiltroMesmoMes(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta c : contas) {
			if (c.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)
					&& c.getDataAbertura().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
				filtrada.add(c);
			}
		}

		filtrada.addAll(aplicaProximoFiltro(contas));
		return filtrada;
	}

}
