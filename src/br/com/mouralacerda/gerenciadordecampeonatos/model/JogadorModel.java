package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class JogadorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codJogador;
	private String nomeJogador;

	public int getCodJogador() {
		return codJogador;
	}

	public void setCodJogador(int codJogador) {
		this.codJogador = codJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJOgador) {
		this.nomeJogador = nomeJOgador;
	}

}
