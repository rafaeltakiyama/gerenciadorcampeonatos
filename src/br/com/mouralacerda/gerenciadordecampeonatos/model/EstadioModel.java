package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class EstadioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codEstadio;
	private String nomeEstadio;

	public int getCodEstadio() {
		return codEstadio;
	}

	public void setCodEstadio(int codEstadio) {
		this.codEstadio = codEstadio;
	}

	public String getNomeEstadio() {
		return nomeEstadio;
	}

	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
	
	@Override
	public String toString() {
		return getNomeEstadio();
	}

}
