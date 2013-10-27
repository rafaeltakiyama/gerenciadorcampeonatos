package br.com.mouralacerda.gerenciadordecampeonatos.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.BancoHelper;

public abstract class Dao<T> {

	private Context context;

	protected abstract String nomeTabela();

	protected abstract String whereClause(T element);

	protected abstract String[] whereValues(T element);

	protected abstract T fromCursor(Cursor cursor);

	protected abstract ContentValues fromElement(T element);
	
	protected abstract void configure(T element, Long codigo);

	protected abstract boolean igual(T elementoLocal, T elementoWs);

	@SuppressWarnings("unused")
	private SQLiteDatabase db;

	public Boolean addListObj(List<T> element) {
		
		try {
			String sql = "select * from " + nomeTabela() + ";";
			List<T> listElementoLocal = selectAllImpl(sql, null);
						
			if (element.size() > 0)
				Log.i(element.get(0).getClass().getSimpleName(), "Inserindo...");
			
			BancoHelper.instance().db.beginTransaction();
			try {
				for (T fromWs : element) {
					if (!(verificaElementRepetido(fromWs, listElementoLocal))) {
						insert(fromWs);
					}
				}
				BancoHelper.instance().db.setTransactionSuccessful();
			} finally {
				BancoHelper.instance().db.endTransaction();
			}
			
//			Log.i("db","Fechando banco...");
//			BancoHelper.instance().close();
		} catch (Exception e) {
			Log.e("Dao", "Erro: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean verificaElementRepetido(T elementoWs, List<T> listElementoLocal) {

		Boolean aux = false;

		if (!(listElementoLocal == null)) {
			for (T elementoLocal : listElementoLocal) {
				if (igual(elementoLocal,elementoWs)) {
					aux = true;
					return aux;
				}
			}
		}
		return aux;
	}

	protected SQLiteDatabase db() {
		return BancoHelper.instance().db;
	}

	public Dao(Context context) {
		//db = BancoHelper.instance().open(context);
//		Log.i("db","Abrindo banco...");
		this.context = context;
	}

	protected Context getContext() {
		return context;
	}
	
	public void insert(T element) {
		ContentValues values = fromElement(element);
		
		if (BancoHelper.instance().db.isOpen()) {
			Long insert = BancoHelper.instance().db.insertWithOnConflict(nomeTabela(), null,
					values, SQLiteDatabase.CONFLICT_REPLACE);
			configure(element, insert);
			//Log.i(element.getClass().getSimpleName(), "Inserindo...");
		}
	}

	public void update(T element) {
		ContentValues values = fromElement(element);

		BancoHelper.instance().db.update(nomeTabela(), values, whereClause(element),
				whereValues(element));
	}

	public void delete(T element) {
		BancoHelper.instance().db.delete(nomeTabela(), whereClause(element),
				whereValues(element));
	}

	public T select(long codigo, T element) {

		String sql = "select * from " + nomeTabela() + " where "
				+ whereClause(element);

		return selectImpl(element, sql, String.valueOf(codigo));
	}

	protected T selectImpl(T element, String sql, String... parametros) { // var
																			// args
																			// permite
																			// passar
																			// n
																			// parametros
		Cursor cursor = null;
		try {
			cursor = BancoHelper.instance().db.rawQuery(sql, parametros);

			if (cursor.getCount() > 0 && cursor.moveToFirst()) {
				return fromCursor(cursor);
			}

			throw new RuntimeException("Não entrou no select");

		} finally {

			if (cursor != null && !cursor.isClosed()) {
				cursor.close();
			}
		}

	}
	
	public List<T> selectBy()
	{
		//SQLiteQueryBuilder
		
		return null;		
	}

	public List<T> selectAll() {
		return selectAllImpl("select * from " + nomeTabela());
	}

	protected List<T> selectAllImpl(String sql,	String... parametros) {
		Cursor cursor = null;
		try {
			BancoHelper.instance();
			cursor = BancoHelper.db.rawQuery(sql, parametros);

			if (cursor.getCount() > 0 && cursor.moveToFirst()) {
				List<T> result = new ArrayList<T>();
				do {
					result.add(fromCursor(cursor));
				} while (cursor.moveToNext());

				return result;
			}

			return null;
			//throw new RuntimeException("Não entrou no select");

		} finally {

			if (cursor != null && !cursor.isClosed()) {
				cursor.close();
			}
		}
	}

}
