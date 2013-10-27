package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class JuizModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codJuiz;
	private String nomeJuiz;

	public int getCodJuiz() {
		return codJuiz;
	}

	public void setCodJuiz(int codJuiz) {
		this.codJuiz = codJuiz;
	}

	public String getNomeJuiz() {
		return nomeJuiz;
	}

	public void setNomeJuiz(String nomeJuiz) {
		this.nomeJuiz = nomeJuiz;
	}
	
	@Override
	public String toString() {
		return "Nome: \n"+ getNomeJuiz();
	}

}
