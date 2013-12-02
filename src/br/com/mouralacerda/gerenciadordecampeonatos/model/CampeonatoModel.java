package br.com.mouralacerda.gerenciadordecampeonatos.model;

import java.io.Serializable;
import java.util.List;

import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;

public class CampeonatoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCampeonato;
	private String nomeCampeonato;

	public Boolean salvar(List<CampeonatoModel> element) {
		return DaoFactory.get(CampeonatoModel.class).addListObj(element);
	}

	public int getCodCampeonato() {
		return codCampeonato;
	}

	public void setCodCampeonato(int codCampeonato) {
		this.codCampeonato = codCampeonato;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	@Override
	public String toString() {
		return getNomeCampeonato(); 
	}
	
}
