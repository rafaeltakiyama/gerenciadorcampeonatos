package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class PartidaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampenato;
	private int numeroRodada;
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

	public int getNumeroRodada() {
		return numeroRodada;
	}

	public void setNumeroRodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
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
