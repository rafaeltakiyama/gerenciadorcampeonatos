package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;

public class PartidaController {

	public static List<PartidaModel> getPartidas(Context context){

		List<PartidaModel> partidaList = new ArrayList<PartidaModel>();
		
		//DaoFactory.init(context);
		BancoHelper.instance().open(context);
		partidaList = DaoFactory.get(PartidaModel.class).selectAll();
		BancoHelper.instance().close();
		
		if(partidaList == null){
			return null;
		}else{
			return partidaList;
		}
	}
	
}
