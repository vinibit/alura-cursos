package alura.curso.aula02;

import alura.curso.aula05.Documento;

public class CNPJ implements Documento {
	private String valor;

	public CNPJ(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CNPJ other = (CNPJ) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.valor;
	}

	@Override
	public boolean ehValido() {
		return true;
	}
	
}
