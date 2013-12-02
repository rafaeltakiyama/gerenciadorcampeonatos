package br.com.mouralacerda.gerenciadordecampeonatos;

import java.io.IOException;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.MenuPrincipalAdapter;
import br.com.mouralacerda.gerenciadordecampeonatos.banco.DataBaseCopy;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;

import com.example.gerenciadordecampeonatos.R;

public class AtividadePrincipalIcon extends ListActivity {

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;
//---------------------------------------
		 DataBaseCopy myDbHelper = new DataBaseCopy(context);
	        myDbHelper = new DataBaseCopy(this);
	 
	        try {
	 
	        	myDbHelper.createDataBase();
	 
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	}
	 
	 	try {
	 
	 		myDbHelper.openDataBase();
	 
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}finally{
	 		myDbHelper.close();
	 	}
//---------------------------------------
		DaoFactory.init(context);
		
		Resources res = context.getResources();

		String[] itens = res.getStringArray(R.array.itens_menu);
		TypedArray icons = res.obtainTypedArray(R.array.itens_ico);

		setListAdapter(new MenuPrincipalAdapter(context,
				R.layout.layout_item_menu_principal, itens, icons));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
		case 0:
			startActivity(new Intent(this, AtividadeListaCampeonatoAberto.class));
			break;

		case 1:
			startActivity(new Intent(this, AtividadeListExpJogadorTimeCampeonato.class));
			break;

		case 2:
			startActivity(new Intent(this, AtividadeListaJogador.class));
			break;

		case 3:
			startActivity(new Intent(this, AtividadeListaTime.class));
			break;

		case 4:
			startActivity(new Intent(this, AtividadeListaEstadios.class));
			break;

		case 5:
			startActivity(new Intent(this, AtividadeListaJuiz.class));
			break;

		case 6:
			startActivity(new Intent(this, AtividadeListaCampeonatos.class));
			break;
			
		default:
			finish();
		}
		
		
	}
	
}
