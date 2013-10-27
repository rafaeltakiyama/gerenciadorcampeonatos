package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class TimeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codTime;
	private String nomeTime;

	public int getCodTime() {
		return codTime;
	}

	public void setCodTime(int codTime) {
		this.codTime = codTime;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

}
