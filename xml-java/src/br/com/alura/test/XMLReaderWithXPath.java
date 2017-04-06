package br.com.alura.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLReaderWithXPath {
	public static void main(String[] args) throws Exception {
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		
		DocumentBuilder builder = getFactory().newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		
		NodeList produtos = (NodeList) xPath
			.compile("/venda/produtos/produto[2]")
			.evaluate(document, XPathConstants.NODESET);
		
		imprimeProdutos(produtos);
	}
	
	private static DocumentBuilderFactory getFactory() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		return factory;
	}
	
	private static void imprimeProdutos(NodeList nodes) {
		for (int i = 0; i < nodes.getLength(); i++) {
			Element produtoTag = (Element) nodes.item(i);
			
			String nome = produtoTag.getElementsByTagName("nome").item(0).getTextContent();
			String preco = produtoTag.getElementsByTagName("preco").item(0).getTextContent();
			
			System.out.println("Nome: " + nome);
			System.out.println("Preço: " + Double.valueOf(preco));
			System.out.println("----------------------------\n");
		}
	}
}
