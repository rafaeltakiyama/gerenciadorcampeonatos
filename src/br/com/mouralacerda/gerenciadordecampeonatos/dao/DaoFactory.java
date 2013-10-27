package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;

import android.content.Context;

public class DaoFactory {

	private static Map<Class<?>, Dao<?>> daos;
	
	public static void init(Context context){
		daos = new HashMap<Class<?>, Dao<?>>();
		
		daos.put(CampeonatoModel.class, new CampeonatoDao(context));
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Dao<T> get(Class<T> type){
		return(Dao<T>) daos.get(type);
	}
}
