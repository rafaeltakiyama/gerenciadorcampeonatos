package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

public class PartidaDao extends Dao<PartidaModel> {

	public PartidaDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbpartida";
	}

	@Override
	protected String whereClause() {
		return "codPartida = ?";
	}

	@Override
	protected String[] whereValues(PartidaModel element) {
		return new String[]{String.valueOf(element.getCodPartida())};
	}

	@Override
	protected PartidaModel fromCursor(Cursor cursor) {

		PartidaModel pModel = new PartidaModel();
		
		int idxCodPartida = cursor.getColumnIndex("codPartida");
		pModel.setCodPartida(cursor.getInt(idxCodPartida));
		
		RodadaDao daoRodada = (RodadaDao) DaoFactory.get(RodadaModel.class);
		int idxRodadaPartida = cursor.getColumnIndex("codRodadaPartida");
		pModel.setRodadaPartida(daoRodada.select(cursor.getInt(idxRodadaPartida)));
		
//		CampeonatoDao daoCamp = (CampeonatoDao) DaoFactory.get(CampeonatoModel.class);		
//		int idxCampeonatoPartida = cursor.getColumnIndex("codCampeonatoPartida");
//		pModel.setCampeonatoPartida(daoCamp.select(cursor.getInt(idxCampeonatoPartida)));
		
		JuizDao daoJuiz = (JuizDao) DaoFactory.get(JuizModel.class);
		int idxJuizPartida = cursor.getColumnIndex("codJuizPartida");
		pModel.setJuizPartida(daoJuiz.select(cursor.getInt(idxJuizPartida)));
		
		EstadioDao daoEst = (EstadioDao) DaoFactory.get(EstadioModel.class);
		int idxEstadioPartida = cursor.getColumnIndex("codEstadioPartida");
		pModel.setEstadioPartida(daoEst.select(cursor.getInt(idxEstadioPartida)));

		TimeDao daoTime1 = (TimeDao) DaoFactory.get(TimeModel.class);
		int idxTime1Partida = cursor.getColumnIndex("codTime1Partida");
		pModel.setTime1Partida(daoTime1.select(cursor.getInt(idxTime1Partida)));
		
		TimeDao daoTime2 = (TimeDao) DaoFactory.get(TimeModel.class);
		int idxTime2Partida = cursor.getColumnIndex("codTime2Partida");
		pModel.setTime2Partida(daoTime2.select(cursor.getInt(idxTime2Partida)));
		
		return pModel;
	}

	@Override
	protected ContentValues fromElement(PartidaModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codPartida", element.getCodPartida());
//		values.put("campeonatoPartida", element.getCampeonatoPartida().getCodCampeonato());
		values.put("rodadaPartida", element.getRodadaPartida().getCodRodada());
		values.put("juizPartida", element.getJuizPartida().getCodJuiz());
		values.put("estadioPartida", element.getEstadioPartida().getCodEstadio());
		values.put("time1Partida", element.getTime1Partida().getCodTime());
		values.put("time2Partida", element.getTime2Partida().getCodTime());
		
		return values;
	}

	@Override
	protected void configure(PartidaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(PartidaModel elementoLocal, PartidaModel elementoWs) {
		return true;
	}

}
