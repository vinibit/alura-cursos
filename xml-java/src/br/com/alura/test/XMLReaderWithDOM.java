package br.com.alura.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLReaderWithDOM {
	
	private void imprimeProdutos(Document document) {
		NodeList nodes = document.getElementsByTagName("produto");
		for (int i = 0; i < nodes.getLength(); i++) {
			Element produtoTag = (Element) nodes.item(i);
			
			String nome = produtoTag.getElementsByTagName("nome").item(0).getTextContent();
			String preco = produtoTag.getElementsByTagName("preco").item(0).getTextContent();
			
			System.out.println("Produto " + (i + 1));
			System.out.println("Nome: " + nome);
			System.out.println("Preço: " + Double.valueOf(preco));
			System.out.println("----------------------------\n");
		}
	}

	private void read() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse("src/vendas.xml");
		
		String moeda = document.getDocumentElement().getAttribute("moeda");
		
		Element tag = (Element) document.getElementsByTagName("formaPagamento").item(0);
		String formaDePagamento = tag.getTextContent();
		
		System.out.println(moeda);
		System.out.println(formaDePagamento);
	}
	
	private static DocumentBuilderFactory getFactory() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		return factory;
	}
	
	public static void main(String[] args) {
		try {
			DocumentBuilder builder = getFactory().newDocumentBuilder();
			Document document = builder.parse("src/vendas.xml");
			
			new XMLReaderWithDOM().imprimeProdutos(document);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
