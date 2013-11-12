package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

public class JogadorTimeCampeonatoDao extends Dao<JogadorTimeCampeonatoModel>{

	public JogadorTimeCampeonatoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tb_jogador_time_campeonato";
	}

	@Override
	protected String whereClause() {
		return "codJogadorTimeCampeonato = ?";
	}

	@Override
	protected String[] whereValues(JogadorTimeCampeonatoModel element) {
		return new String[]{String.valueOf(element.getCodJogadorTimeCampeonato())};
	}

	@Override
	protected JogadorTimeCampeonatoModel fromCursor(Cursor cursor) {

		JogadorTimeCampeonatoModel jtcModel = new JogadorTimeCampeonatoModel();
		
		int idxCodJogadorTimeCampeonato = cursor.getColumnIndex("codJogadorTimeCampeonato");
		jtcModel.setCodJogadorTimeCampeonato(cursor.getInt(idxCodJogadorTimeCampeonato));
		
		CampeonatoDao campDao = (CampeonatoDao) DaoFactory.get(CampeonatoModel.class);
		int idxCampeonato = cursor.getColumnIndex("campeonato");
		jtcModel.setCampeonato(campDao.select(cursor.getInt(idxCampeonato)));
		
		TimeDao timeDao = (TimeDao) DaoFactory.get(TimeModel.class);
		int idxTime = cursor.getColumnIndex("times");
		jtcModel.setTime(timeDao.select(cursor.getInt(idxTime)));
		
		JogadorDao jogDao = (JogadorDao) DaoFactory.get(JogadorModel.class);
		int idxJogador = cursor.getColumnIndex("jogador");
		jtcModel.setJogador(jogDao.select(cursor.getInt(idxJogador)));
		
		return jtcModel;
	}

	@Override
	protected ContentValues fromElement(JogadorTimeCampeonatoModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codJogadorTimeCampeonato", element.getCodJogadorTimeCampeonato());
		values.put("campeonato", element.getCampeonato().getCodCampeonato());
		values.put("times", element.getTime().getCodTime());
		values.put("jogador", element.getJogador().getCodJogador());
		                                        
		return values;
	}

	@Override
	protected void configure(JogadorTimeCampeonatoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(JogadorTimeCampeonatoModel elementoLocal,
			JogadorTimeCampeonatoModel elementoWs) {
		return true;
	}

}
