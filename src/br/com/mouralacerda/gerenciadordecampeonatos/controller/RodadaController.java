package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

public class RodadaController {

	public static List<RodadaModel> getRodadas(Context context){

		List<RodadaModel> rodadaList = new ArrayList<RodadaModel>();
		
		//DaoFactory.init(context);
		BancoHelper.instance().open(context);
		rodadaList = DaoFactory.get(RodadaModel.class).selectAll();
		BancoHelper.instance().close();
		
		return rodadaList;
	}
	
	public static boolean salvarRodada(Context context, List<RodadaModel> lisRodadaModel){
		
		if(lisRodadaModel != null){
			RodadaModel rodada = new RodadaModel();
			rodada.salvar(lisRodadaModel);
			return true;
		}else{
			return false;
		}
	}
}
