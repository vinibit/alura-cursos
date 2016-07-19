package alura.curso.designpatterns1.filtro;

import java.util.ArrayList;
import java.util.List;

import alura.curso.designpatterns1.model.resposta.Conta;

public class FiltroMenorQue100 extends Filtro {
	
	public FiltroMenorQue100() {
		super();
	}
	
	public FiltroMenorQue100(Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
        for(Conta c : contas) {
          if(c.getSaldo() < 100) filtrada.add(c);
        }

        filtrada.addAll(aplicaProximoFiltro(contas));
        return filtrada;
	}

}
