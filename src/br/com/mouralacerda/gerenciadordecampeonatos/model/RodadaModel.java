package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class RodadaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampenato;
	private int codRodada;

	public int getCodCampenato() {
		return codCampenato;
	}

	public void setCodCampenato(int codCampenato) {
		this.codCampenato = codCampenato;
	}

	public int getCodRodada() {
		return codRodada;
	}

	public void setCodRodada(int codRodada) {
		this.codRodada = codRodada;
	}

}
