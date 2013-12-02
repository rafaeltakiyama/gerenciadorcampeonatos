package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;

public class CampeonatoController {

	public static List<CampeonatoModel> getCampenatos(Context context){

		List<CampeonatoModel> campenatoList = new ArrayList<CampeonatoModel>();
		
		//DaoFactory.init(context);
		BancoHelper.instance().open(context);
		campenatoList = DaoFactory.get(CampeonatoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return campenatoList;
	}
	
	public static List<CampeonatoModel> getCampeonatoPorCodigo(Context context, int codCampeonato) {
		
		String sql = "select * from tbcampeonato where codCampeonato = ?";
		
		List<CampeonatoModel> campeonatoList = new ArrayList<CampeonatoModel>();
		
		BancoHelper.instance().open(context);
		campeonatoList = DaoFactory.get(CampeonatoModel.class).selectAllImpl(sql, String.valueOf(codCampeonato));
		BancoHelper.instance().close();
		
		return campeonatoList;
	}
	
}
