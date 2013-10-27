package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;

public class JogadorController {

	public static List<JogadorModel> getJogador(Context context){
		
		List<JogadorModel> jogadorList = new ArrayList<JogadorModel>();
		
		BancoHelper.instance().open(context);
		jogadorList = DaoFactory.get(JogadorModel.class).selectAll();
		BancoHelper.instance().close();
		
		return jogadorList;
	}
	
}
