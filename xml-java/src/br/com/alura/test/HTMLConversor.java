package br.com.alura.test;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class HTMLConversor {
	
	public static void main(String[] args) throws Exception {
		InputStream template = new FileInputStream("src/xml-html.xsl");
		StreamSource xslSource = new StreamSource(template);
			
		FileInputStream vendas = new FileInputStream("src/vendas.xml");
		StreamSource xmlSource = new StreamSource(vendas);
		
		StreamResult htmlResult = new StreamResult("src/vendas.html");
		TransformerFactory.newInstance()
			.newTransformer(xslSource)
			.transform(xmlSource, htmlResult);
		
		System.out.println("Conversão concluída com sucesso.");
	}
	
}
