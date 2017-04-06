package br.com.alura.test;

import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutosHandler;

public class XMLReaderWithSAX {
	public static void main(String[] args) throws Exception {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		ProdutosHandler handler = new ProdutosHandler();
		reader.setContentHandler(handler);
		
		FileInputStream stream = new FileInputStream("src/vendas.xml");
		reader.parse(new InputSource(stream));
		
		System.out.println(handler.getPodutos());
	}
}
