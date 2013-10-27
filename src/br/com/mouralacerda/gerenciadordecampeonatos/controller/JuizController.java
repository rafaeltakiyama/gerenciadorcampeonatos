package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;

public class JuizController {
	public static List<JuizModel> getJuiz(Context context){
		
		List<JuizModel> juizList = new ArrayList<JuizModel>();
		
		BancoHelper.instance().open(context);
		juizList = DaoFactory.get(JuizModel.class).selectAll();
		BancoHelper.instance().close();
		
		return juizList;
	}
}
