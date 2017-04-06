package br.com.alura.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Produto;

public class ProdutosHandler extends DefaultHandler {
	
	private Produto produto;
	private List<Produto> produtos = new ArrayList<>();
	private StringBuilder builder = new StringBuilder();  
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("produto")) {
			produto = new Produto();
		}
		builder = new StringBuilder();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("produto")) {
			produtos.add(produto);
		} else if (qName.equals("nome")) {
			produto.setNome(builder.toString());
		} else if (qName.equals("preco")) {
			produto.setPreco(Double.valueOf(builder.toString()));
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		builder.append(String.valueOf(ch, start, length));
	}

	public List<Produto> getPodutos() {
		return produtos;
	}
	
}
