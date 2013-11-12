package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;

public class JogadorTimeCampeonatoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codJogadorTimeCampeonato;
	private CampeonatoModel campeonato;
	private TimeModel times;
	private JogadorModel jogador;

	public int getCodJogadorTimeCampeonato() {
		return codJogadorTimeCampeonato;
	}

	public void setCodJogadorTimeCampeonato(int codJogadorTimeCampeonato) {
		this.codJogadorTimeCampeonato = codJogadorTimeCampeonato;
	}

	public CampeonatoModel getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(CampeonatoModel campeonato) {
		this.campeonato = campeonato;
	}

	public TimeModel getTime() {
		return times;
	}

	public void setTime(TimeModel time) {
		this.times = time;
	}

	public JogadorModel getJogador() {
		return jogador;
	}

	public void setJogador(JogadorModel jogador) {
		this.jogador = jogador;
	}

}
