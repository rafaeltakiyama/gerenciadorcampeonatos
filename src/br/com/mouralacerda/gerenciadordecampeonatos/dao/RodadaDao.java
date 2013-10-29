package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

public class RodadaDao extends Dao<RodadaModel>{

	public RodadaDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbrodada";
	}

	@Override
	protected String whereClause(RodadaModel element) {
		return "codRodada = ?";
	}

	@Override
	protected String[] whereValues(RodadaModel element) {
		return new String[]{String.valueOf(element.getCodRodada())};
	}

	@Override
	protected RodadaModel fromCursor(Cursor cursor) {

		RodadaModel rodada = new RodadaModel();
		
		int idxCodRodada = cursor.getColumnIndex("codRodada");
		rodada.setCodRodada(cursor.getInt(idxCodRodada));
		
		int idxCodCampeonatoRodada = cursor.getColumnIndex("codCampeonatoRodada");
		rodada.setCodCampeonatoRodada(cursor.getInt(idxCodCampeonatoRodada));
		
		return rodada;
	}

	@Override
	protected ContentValues fromElement(RodadaModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codRodada", element.getCodRodada());
		values.put("codCampeonatoRodada", element.getCodCampeonatoRodada());
		
		return values;
	}

	@Override
	protected void configure(RodadaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(RodadaModel elementoLocal, RodadaModel elementoWs) {
		return elementoLocal.getCodRodada() == elementoWs.getCodRodada()
				&& elementoLocal.getCodCampeonatoRodada() == elementoWs.getCodCampeonatoRodada();
	}

}
