package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;
import java.util.List;

import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;

public class RodadaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampeonatoRodada;
	private int codRodada;

	public Boolean salvar(List<RodadaModel> element) {
		return DaoFactory.get(RodadaModel.class).addListObj(element);
	}
	
	public int getCodCampeonatoRodada() {
		return codCampeonatoRodada;
	}

	public void setCodCampeonatoRodada(int codCampeonatoRodada) {
		this.codCampeonatoRodada = codCampeonatoRodada;
	}

	public int getCodRodada() {
		return codRodada;
	}

	public void setCodRodada(int codRodada) {
		this.codRodada = codRodada;
	}

}
