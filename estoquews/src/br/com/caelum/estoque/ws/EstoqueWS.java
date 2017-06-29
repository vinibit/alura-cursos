package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.exception.AutorizacaoException;
import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {
	
	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName = "TodosItens")
	@RequestWrapper(localName = "listaItens")
	@ResponseWrapper(localName = "itens")
	@WebResult(name = "item")
	public List<Item> getItems() {
		return dao.todosItens();
	}
	
	@WebMethod(operationName = "TodosItensFiltrados")
	@WebResult(name = "itens")
	public ListaItens getItemsByFilter(@WebParam(name = "filtros") Filtros filtros) {
		List<Filtro> lista = filtros.getLista();
		return new ListaItens(dao.todosItens(lista));
	}
	
	@WebMethod(operationName = "CadastrarItem")
	public Item cadastraItem(@WebParam(name = "usuario", header = true) TokenUsuario usuario, 
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		if (!new TokenDao().ehValido(usuario)) 
			throw new AutorizacaoException("Autorização Falhou");
		
		new ItemValidador(item).validate();
		
		System.out.println("Cadastrando novo " + item);
		dao.cadastrar(item);
		return item;
	}
	
	@Oneway
	@WebMethod(operationName = "AuditarItem")
	public void auditaItem(@WebParam(name = "codigoItem") String codigo) {
		Item item = dao.obtemItem(codigo);
		System.out.println("Auditando item " + item.getNome() + ".");
	}
}
