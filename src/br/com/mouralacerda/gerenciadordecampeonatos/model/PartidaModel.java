package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class PartidaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampenato;
	private int codRodada;
	private int codPartida;
	private int codJuiz;
	private int codEstadio;
	private int codTime;

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

	public int getCodPartida() {
		return codPartida;
	}

	public void setCodPartida(int codPartida) {
		this.codPartida = codPartida;
	}

	public int getCodJuiz() {
		return codJuiz;
	}

	public void setCodJuiz(int codJuiz) {
		this.codJuiz = codJuiz;
	}

	public int getCodEstadio() {
		return codEstadio;
	}

	public void setCodEstadio(int codEstadio) {
		this.codEstadio = codEstadio;
	}

	public int getCodTime() {
		return codTime;
	}

	public void setCodTime(int codTime) {
		this.codTime = codTime;
	}

}
