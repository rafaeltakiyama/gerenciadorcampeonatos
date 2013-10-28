package br.com.mouralacerda.gerenciadordecampeonatos.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

public class TimeController {

	public static List<TimeModel> getTime(Context context){
		
		List<TimeModel> timeList = new ArrayList<TimeModel>();
		
		BancoHelper.instance().open(context);
		timeList = DaoFactory.get(TimeModel.class).selectAll();
		BancoHelper.instance().close();
		
		return timeList;
	}
	
}
