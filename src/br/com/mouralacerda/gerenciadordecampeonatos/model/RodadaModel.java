package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;
import java.util.List;

import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;

public class RodadaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private CampeonatoModel CampeonatoRodada;
	private int codRodada;
	private int numeroRodada;

	public Boolean salvar(List<RodadaModel> element) {
		return DaoFactory.get(RodadaModel.class).addListObj(element);
	}

	public CampeonatoModel getCampeonatoRodada() {
		return CampeonatoRodada;
	}

	public void setCampeonatoRodada(CampeonatoModel campeonatoRodada) {
		this.CampeonatoRodada = campeonatoRodada;
	}

	public int getCodRodada() {
		return codRodada;
	}

	public void setCodRodada(int codRodada) {
		this.codRodada = codRodada;
	}

	public int getNumeroRodada() {
		return numeroRodada;
	}

	public void setNumeroRodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
	}

}
