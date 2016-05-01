package alura.curso.designpatterns1.test;

import alura.curso.designpatterns1.chainofresponsability.resposta.CadeiaFormatacaoDeReposta;
import alura.curso.designpatterns1.chainofresponsability.resposta.Resposta;
import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Formato;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public class TesteDeResposta {
	public static void main(String[] args) {
		CadeiaFormatacaoDeReposta cadeiaFormatacaoDeReposta = new CadeiaFormatacaoDeReposta();
		Resposta resposta = cadeiaFormatacaoDeReposta.encadeia();
		
		Requisicao req = new Requisicao(Formato.PORCENTO);
		Conta conta = new Conta("Vinicius", 1000);
		
		resposta.responde(req, conta);
	}
}
