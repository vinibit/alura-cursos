package alura.curso.designpatterns1.chainofresponsability.resposta;

public class CadeiaFormatacaoDeReposta {
	
	public Resposta encadeia() {
		Resposta respostaCSV = 
				new RespostaCSV(
						new RespostaXML(
								new RespostaPorcento(null)));
		
//		respostaCSV.setProxima(respostaXML);
//		respostaXML.setProxima(respostaPorcento);
//		respostaPorcento.setProxima(semResposta);
		
		return respostaCSV;
	}
}
