package br.com.caelum.estoque.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.caelum.estoque.ws.FaultInfo;

@WebFault(name = "AutorizacaoFault", messageName = "AutorizacaoFault")
public class AutorizacaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String message) {
		super(message);
	}

	public FaultInfo getFaultInfo() {
        return new FaultInfo(new Date(), "Token inválido.");
    }
}
