package alura.curso.aula06;

import java.util.HashMap;
import java.util.Map;

import alura.curso.aula01.Divida;
import alura.curso.aula05.Documento;

public class BancoDeDados implements ArmazenadorDeDividas {
	private Map<Documento, Divida> dividasNoBanco = new HashMap<Documento, Divida>();
	
	public void conectar(String local, String usuario, String senha) {
		System.out.println("Conectado!");
	}
	
	public void desconectar() {
		System.out.println("Desconectado!");
	}
	
	/* (non-Javadoc)
	 * @see exercicios.ArmazenadorDeDividas#gravaDivida(exercicios.Divida)
	 */
	@Override
	public void grava(Divida divida) {
		dividasNoBanco.put(divida.getDocumentoCredor(), divida);
	}
	
	/* (non-Javadoc)
	 * @see exercicios.ArmazenadorDeDividas#obtemDivida(exercicios.Documento)
	 */
	@Override
	public Divida obtem(Documento documento) {
		return dividasNoBanco.get(documento);
	}
}
