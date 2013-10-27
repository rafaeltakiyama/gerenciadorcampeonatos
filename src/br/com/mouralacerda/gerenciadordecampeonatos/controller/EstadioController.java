package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;

public class EstadioController {

	public static List<EstadioModel> getEstadios(Context context){

		List<EstadioModel> estadioList = new ArrayList<EstadioModel>();
		
		DaoFactory.init(context);
		BancoHelper.instance().open(context);
		estadioList = DaoFactory.get(EstadioModel.class).selectAll();
		BancoHelper.instance().close();
		
		return estadioList;
	}
	
}
