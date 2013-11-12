package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

import android.content.Context;

public class DaoFactory {

	private static Map<Class<?>, Dao<?>> daos;
	
	public static void init(Context context){
		daos = new HashMap<Class<?>, Dao<?>>();
		
		daos.put(CampeonatoModel.class, new CampeonatoDao(context));
		daos.put(EstadioModel.class, new EstadioDao(context));
		daos.put(JogadorModel.class, new JogadorDao(context));
		daos.put(JuizModel.class, new JuizDao(context));
		daos.put(TimeModel.class, new TimeDao(context));
		daos.put(RodadaModel.class, new RodadaDao(context));
		daos.put(PartidaModel.class, new PartidaDao(context));
		daos.put(JogadorTimeCampeonatoModel.class, new JogadorTimeCampeonatoDao(context));
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Dao<T> get(Class<T> type){
		return(Dao<T>) daos.get(type);
	}
}
