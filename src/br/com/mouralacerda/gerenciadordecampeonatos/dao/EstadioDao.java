package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;

public class EstadioDao extends Dao<EstadioModel>{

	public EstadioDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbestadio";
	}

	@Override
	protected String whereClause() {
		return "codEstadio = ?";
	}

	@Override
	protected String[] whereValues(EstadioModel element) {
		return new String[]{String.valueOf(element.getCodEstadio())};
	}

	@Override
	protected EstadioModel fromCursor(Cursor cursor) {

		EstadioModel estadioModel =  new EstadioModel();
		
		int idxCodEstadio = cursor.getColumnIndex("codEstadio");
		estadioModel.setCodEstadio(cursor.getInt(idxCodEstadio));
		
		int idxNomeEstadio = cursor.getColumnIndex("nomeEstadio");
		estadioModel.setNomeEstadio(cursor.getString(idxNomeEstadio));
		
		return estadioModel;
	}

	@Override
	protected ContentValues fromElement(EstadioModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codEstadio", element.getCodEstadio());
		values.put("nomeEstadio", element.getNomeEstadio());
		
		return values;
	}

	@Override
	protected void configure(EstadioModel element, Long codigo) {
	}

	@Override
	protected boolean igual(EstadioModel elementoLocal, EstadioModel elementoWs) {
		return false;
	}

}
