package br.com.alura.test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class XMLReaderWithStAX {
	public static void main(String[] args) throws Exception {
		FileInputStream stream = new FileInputStream("src/vendas.xml");
		XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(stream);
		
		List<Produto> produtos = new ArrayList<>(); 
		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				produtos.add(createProduto(reader));
			}
		}
		
		System.out.println(produtos);
	}
	
	private static Produto createProduto(XMLEventReader reader) throws XMLStreamException {
		Produto produto = new Produto();
		
		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			
			if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
			
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = reader.nextEvent();
				produto.setNome(event.asCharacters().getData());
			}
			
			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
				event = reader.nextEvent();
				produto.setPreco(Double.valueOf(event.asCharacters().getData()));
			}
			
		} 
		
		return produto;
	}
}
