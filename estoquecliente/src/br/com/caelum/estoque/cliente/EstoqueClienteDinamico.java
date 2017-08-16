package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class EstoqueClienteDinamico {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/estoqueweb/EstoqueWS?wsdl");
		QName qName = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");
		
		Service service = Service.create(url, qName);
		
		EstoqueWS cliente = service.getPort(EstoqueWS.class);
		
		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);
		
		ListaItens itens = cliente.todosOsItens(new Filtros(Arrays.asList(filtro)));
		for (Item item : itens.getItem()) {
			System.out.println(item.getNome());
		}
	}

}
