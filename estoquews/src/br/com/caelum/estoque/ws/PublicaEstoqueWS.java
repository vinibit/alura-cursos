package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {
	public static void main(String[] args) {
		EstoqueWS ws = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";
		
		System.out.println("EstoqueWS publicado em: " + URL);
		
		Endpoint.publish(URL, ws);
	}
}
