package alura.curso.designpatterns1.chainofresponsability.resposta;

import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Formato;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public class RespostaPorcento implements Resposta {
	private Resposta proxima;

	public RespostaPorcento(Resposta proxima) {
		this.proxima = proxima;
	}

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato().equals(Formato.PORCENTO)) {
			System.out.println(formataEmPercentual(conta));
		} else {
			proxima.responde(req, conta);
		}
	}

	private String formataEmPercentual(Conta conta) {
		StringBuilder builder = new StringBuilder();
		builder.append(conta.getTitular()).append("%");
		builder.append(conta.getSaldo());
		return builder.toString();
	}

	/*public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}*/
}
