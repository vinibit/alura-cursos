package alura.curso.designpatterns1.chainofresponsability.resposta;

import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public class SemResposta implements Resposta {

	public void responde(Requisicao req, Conta conta) {
		System.out.println("--SEM RESPOSTA--");
	}

	public void setProxima(Resposta resposta) {
		throw new UnsupportedOperationException();
	}

}
