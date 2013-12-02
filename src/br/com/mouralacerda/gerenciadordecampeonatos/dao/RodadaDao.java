package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import java.util.Collections;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
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
	protected String whereClause() {
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
		
		int idxNumeroRodada = cursor.getColumnIndex("numeroRodada");
		rodada.setNumeroRodada((cursor.getInt(idxNumeroRodada)));
		
		CampeonatoDao dao = (CampeonatoDao) DaoFactory.get(CampeonatoModel.class);
		int idxCodCampeonatoRodada = cursor.getColumnIndex("codCampeonatoRodada");
		rodada.setCampeonatoRodada(dao.select(cursor.getInt(idxCodCampeonatoRodada)));
		
		return rodada;
	}

	@Override
	protected ContentValues fromElement(RodadaModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codRodada", element.getCodRodada());
		values.put("numeroRodada", element.getNumeroRodada());
		values.put("codCampeonatoRodada", element.getCampeonatoRodada().getCodCampeonato());
		
		return values;
	}

	@Override
	protected void configure(RodadaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(RodadaModel elementoLocal, RodadaModel elementoWs) {
		return elementoLocal.getCodRodada() == elementoWs.getCodRodada()
				&& elementoLocal.getCampeonatoRodada() == elementoWs.getCampeonatoRodada();
	}
	
	public List<RodadaModel> listaRodada(CampeonatoModel campeonatoModel){
		if(campeonatoModel == null){
			return Collections.emptyList();
		}
		
		String sql = "select * from tbrodada where codCampeonato = ?";
		return selectAllImpl(sql, String.valueOf(campeonatoModel.getCodCampeonato()));
	}

}
