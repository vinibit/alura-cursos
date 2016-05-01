package alura.curso.designpatterns1.chainofresponsability.resposta;

import alura.curso.designpatterns1.model.resposta.Conta;
import alura.curso.designpatterns1.model.resposta.Formato;
import alura.curso.designpatterns1.model.resposta.Requisicao;

public class RespostaXML implements Resposta {
	private Resposta proxima;
	
	
	public RespostaXML(Resposta proxima) {
		this.proxima = proxima;
	}

	public void responde(Requisicao req, Conta conta) {
		// TODO Auto-generated method stub
		if (req.getFormato().equals(Formato.XML)) {
			System.out.println(formataEmXML(conta));
		} else {
			proxima.responde(req, conta);
		}
	}

	private String formataEmXML(Conta conta) {
		StringBuilder builder = new StringBuilder();
		builder.append("<conta>");
		builder.append("<titular>").append(conta.getTitular()).append("</titular>");
		builder.append("<saldo>").append(conta.getSaldo()).append("</saldo>");
		builder.append("</conta>");
		return builder.toString();
	}

	/*public void setProxima(Resposta resposta) {
		this.proxima = resposta;
	}*/

}
