package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

public class TimeDao extends Dao<TimeModel>{

	public TimeDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbtime";
	}

	@Override
	protected String whereClause(TimeModel element) {
		return "codTime = ?";
	}

	@Override
	protected String[] whereValues(TimeModel element) {
		return new String[]{String.valueOf(element.getCodTime())};
	}

	@Override
	protected TimeModel fromCursor(Cursor cursor) {
		
		TimeModel timeModel = new TimeModel();
		
		int idxCodTime = cursor.getColumnIndex("codTime");
		timeModel.setCodTime(cursor.getInt(idxCodTime));
		
		int idxNomeTIme = cursor.getColumnIndex("nomeTime");
		timeModel.setNomeTime(cursor.getString(idxNomeTIme));
		
		return timeModel;
	}

	@Override
	protected ContentValues fromElement(TimeModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codTime", element.getCodTime());
		values.put("nomeTime", element.getNomeTime());
		
		return values;
	}

	@Override
	protected void configure(TimeModel element, Long codigo) {
	}

	@Override
	protected boolean igual(TimeModel elementoLocal, TimeModel elementoWs) {
		return false;
	}

}
