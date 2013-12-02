package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;

public class JogadorTimeCampeonatoController {

	public static List<JogadorTimeCampeonatoModel> getJogadorTimeCampeonato(Context context){
		
		List<JogadorTimeCampeonatoModel> jtclist = new ArrayList<JogadorTimeCampeonatoModel>();
		
		BancoHelper.instance().open(context);
		jtclist = DaoFactory.get(JogadorTimeCampeonatoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return jtclist;
	}
	
}
