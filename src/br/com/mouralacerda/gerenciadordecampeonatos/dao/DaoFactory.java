package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;

import android.content.Context;

public class DaoFactory {

	private static Map<Class<?>, Dao<?>> daos;
	
	public static void init(Context context){
		daos = new HashMap<Class<?>, Dao<?>>();
		
		daos.put(CampeonatoModel.class, new CampeonatoDao(context));
		daos.put(EstadioModel.class, new EstadioDao(context));
		daos.put(JogadorModel.class, new JogadorDao(context));
		daos.put(JuizModel.class, new JuizDao(context));
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Dao<T> get(Class<T> type){
		return(Dao<T>) daos.get(type);
	}
}
