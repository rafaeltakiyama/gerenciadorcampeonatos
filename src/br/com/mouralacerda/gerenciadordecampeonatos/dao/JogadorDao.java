package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;

public class JogadorDao extends Dao<JogadorModel>{

	public JogadorDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbjogador";
	}

	@Override
	protected String whereClause() {
		return "codJogador = ?";
	}

	@Override
	protected String[] whereValues(JogadorModel element) {
		return new String[]{String.valueOf(element.getCodJogador())};
	}

	@Override
	protected JogadorModel fromCursor(Cursor cursor) {

		JogadorModel jogadorModel = new JogadorModel();
		
		int idxCodJogador = cursor.getColumnIndex("codJogador");
		jogadorModel.setCodJogador(cursor.getInt(idxCodJogador));
		
		int idxNomeJogador = cursor.getColumnIndex("nomeJogador");
		jogadorModel.setNomeJogador(cursor.getString(idxNomeJogador));
		
		return jogadorModel;
	}

	@Override
	protected ContentValues fromElement(JogadorModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codJogador", element.getCodJogador());
		values.put("nomeJogador", element.getNomeJogador());
		
		return values;
	}

	@Override
	protected void configure(JogadorModel element, Long codigo) {
	}

	@Override
	protected boolean igual(JogadorModel elementoLocal, JogadorModel elementoWs) {
		return false;
	}

}
