package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;

public class CampeonatoDao extends Dao<CampeonatoModel>{

	public CampeonatoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbcampeonato";
	}

	@Override
	protected String whereClause(CampeonatoModel element) {
		return "codCampeonato = ?";
	}

	@Override
	protected String[] whereValues(CampeonatoModel element) {
		return new String[]{String.valueOf(element.getCodCampeonato())};
	}

	@Override
	protected CampeonatoModel fromCursor(Cursor cursor) {
		
		CampeonatoModel campeonatoModel = new CampeonatoModel();
		
		int idxCodCampenato = cursor.getColumnIndex("codCampeonato");
		campeonatoModel.setCodCampeonato(cursor.getInt(idxCodCampenato));
		
		int idxNomeCampenato  = cursor.getColumnIndex("nomeCampeonato");
		campeonatoModel.setNomeCampeonato(cursor.getString(idxNomeCampenato));
		
		return campeonatoModel;
	}

	@Override
	protected ContentValues fromElement(CampeonatoModel element) {

		ContentValues values = new ContentValues();

		values.put("codCampeonato", element.getCodCampeonato());
		values.put("nomeCampeonato", element.getNomeCampeonato());
		
		return values;
	}

	@Override
	protected boolean igual(CampeonatoModel elementoLocal,
			CampeonatoModel elementoWs) {
		return false;
	}

	@Override
	protected void configure(CampeonatoModel element, Long codigo) {
	}

}
