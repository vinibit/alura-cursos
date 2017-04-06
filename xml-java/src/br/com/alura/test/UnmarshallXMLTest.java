package br.com.alura.test;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Venda;

public class UnmarshallXMLTest {
	public static void main(String[] args) throws Exception {
		FileInputStream stream = new FileInputStream("src/vendas.xml");
		
		JAXBContext context = JAXBContext.newInstance(Venda.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Venda venda = (Venda) unmarshaller.unmarshal(stream);
		
		System.out.println(venda);
	}
}
