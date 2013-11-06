package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class PartidaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codPartida;
	private CampeonatoModel campeonatoPartida;
	private RodadaModel rodadaPartida;
	private JuizModel juizPartida;
	private EstadioModel estadioPartida;
	private TimeModel time1Partida;
	private TimeModel time2Partida;

	public int getCodPartida() {
		return codPartida;
	}

	public void setCodPartida(int codPartida) {
		this.codPartida = codPartida;
	}

	public CampeonatoModel getCampeonatoPartida() {
		return campeonatoPartida;
	}

	public void setCampeonatoPartida(CampeonatoModel campeonatoPartida) {
		this.campeonatoPartida = campeonatoPartida;
	}

	public RodadaModel getRodadaPartida() {
		return rodadaPartida;
	}

	public void setRodadaPartida(RodadaModel rodadaPartida) {
		this.rodadaPartida = rodadaPartida;
	}

	public JuizModel getJuizPartida() {
		return juizPartida;
	}

	public void setJuizPartida(JuizModel juizPartida) {
		this.juizPartida = juizPartida;
	}

	public EstadioModel getEstadioPartida() {
		return estadioPartida;
	}

	public void setEstadioPartida(EstadioModel estadioPartida) {
		this.estadioPartida = estadioPartida;
	}

	public TimeModel getTime1Partida() {
		return time1Partida;
	}

	public void setTime1Partida(TimeModel time1Partida) {
		this.time1Partida = time1Partida;
	}

	public TimeModel getTime2Partida() {
		return time2Partida;
	}

	public void setTime2Partida(TimeModel time2Partida) {
		this.time2Partida = time2Partida;
	}

}
