package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;

public class JuizDao extends Dao<JuizModel>{

	public JuizDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbjuiz";
	}

	@Override
	protected String whereClause() {
		return "codJuiz = ?";
	}

	@Override
	protected String[] whereValues(JuizModel element) {
		return new String[]{String.valueOf(element.getCodJuiz())};
	}

	@Override
	protected JuizModel fromCursor(Cursor cursor) {

		JuizModel juizModel = new JuizModel();
		
		int idxCodJuiz = cursor.getColumnIndex("codJuiz");
		juizModel.setCodJuiz(cursor.getInt(idxCodJuiz));
		
		int idxNomeJuiz = cursor.getColumnIndex("nomeJuiz");
		juizModel.setNomeJuiz(cursor.getString(idxNomeJuiz));
		
		return juizModel;
	}

	@Override
	protected ContentValues fromElement(JuizModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codJuiz", element.getCodJuiz());
		values.put("nomeJuiz", element.getNomeJuiz());
		
		return values;
	}

	@Override
	protected void configure(JuizModel element, Long codigo) {
	}

	@Override
	protected boolean igual(JuizModel elementoLocal, JuizModel elementoWs) {
		return false;
	}

}
