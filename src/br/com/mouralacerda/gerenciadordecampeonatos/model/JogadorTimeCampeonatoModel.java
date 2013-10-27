package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class JogadorTimeCampeonatoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codCampenato;
	private int codTime;
	private int codJogador;

	public int getCodCampenato() {
		return codCampenato;
	}

	public void setCodCampenato(int codCampenato) {
		this.codCampenato = codCampenato;
	}

	public int getCodTime() {
		return codTime;
	}

	public void setCodTime(int codTime) {
		this.codTime = codTime;
	}

	public int getCodJogador() {
		return codJogador;
	}

	public void setCodJogador(int codJogador) {
		this.codJogador = codJogador;
	}

}
