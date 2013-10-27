package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class JogadorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codJogador;
	private String nomeJOgador;

	public int getCodJogador() {
		return codJogador;
	}

	public void setCodJogador(int codJogador) {
		this.codJogador = codJogador;
	}

	public String getNomeJOgador() {
		return nomeJOgador;
	}

	public void setNomeJOgador(String nomeJOgador) {
		this.nomeJOgador = nomeJOgador;
	}

}
