package alura.curso.designpatterns1.chainofresponsability.resposta;

import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public interface Resposta {
	 void responde(Requisicao req, Conta conta);
     //void setProxima(Resposta resposta);
}
