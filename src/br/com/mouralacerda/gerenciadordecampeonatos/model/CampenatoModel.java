package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class CampenatoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampenato;
	private String nomeCampenato;

	public int getCodCampenato() {
		return codCampenato;
	}

	public void setCodCampenato(int codCampenato) {
		this.codCampenato = codCampenato;
	}

	public String getNomeCampenato() {
		return nomeCampenato;
	}

	public void setNomeCampenato(String nomeCampenato) {
		this.nomeCampenato = nomeCampenato;
	}

}
