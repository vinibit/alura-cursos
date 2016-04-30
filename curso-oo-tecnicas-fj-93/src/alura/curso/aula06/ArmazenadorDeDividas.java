package alura.curso.aula06;

import alura.curso.aula01.Divida;
import alura.curso.aula05.Documento;

public interface ArmazenadorDeDividas {

	void grava(Divida divida);

	Divida obtem(Documento documento);

}