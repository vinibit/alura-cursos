package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@ XmlAccessorType(XmlAccessType.FIELD)
public class FaultInfo {
	private Date dataErro;
	private String mensagem;

	public FaultInfo() {
	}	
	
	public FaultInfo(Date dataErro, String mensagem) {
		this.dataErro = dataErro;
		this.mensagem = mensagem;
	}

}
