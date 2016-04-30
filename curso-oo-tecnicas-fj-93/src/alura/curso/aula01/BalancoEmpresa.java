package alura.curso.aula01;

import alura.curso.aula03.Pagamento;
import alura.curso.aula05.Documento;
import alura.curso.aula06.ArmazenadorDeDividas;

public class BalancoEmpresa {
	
    private ArmazenadorDeDividas dividas;
    
    public BalancoEmpresa(ArmazenadorDeDividas dividas) {
		this.dividas = dividas;
	}

	public void registraDivida(Divida divida) {
        dividas.grava(divida);
    }

    public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
        Divida divida = dividas.obtem(documentoCredor);
        if (divida != null) {
            divida.registra(pagamento);
        }
        dividas.grava(divida);
    }
    
}
