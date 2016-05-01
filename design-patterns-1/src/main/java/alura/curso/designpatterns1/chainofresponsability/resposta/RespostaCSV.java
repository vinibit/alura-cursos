package alura.curso.designpatterns1.chainofresponsability.resposta;

import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Formato;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public class RespostaCSV implements Resposta {
	private Resposta proxima;
	
	public RespostaCSV(Resposta proxima) {
		this.proxima = proxima;
	}

	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato().equals(Formato.CSV)) {
			System.out.println(formataEmCSV(conta));
		} else {
			proxima.responde(req, conta);
		}
	}

	private String formataEmCSV(Conta conta) {
		StringBuilder builder = new StringBuilder();
		builder.append(conta.getTitular()).append(",");
		builder.append(conta.getSaldo());
		return builder.toString();
	}

	/*public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}*/

}
