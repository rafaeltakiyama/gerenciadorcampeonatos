package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.AdapterList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.EstadioController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaEstadios extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;

		List<EstadioModel> listaEstadio = new ArrayList<EstadioModel>();

		listaEstadio = EstadioController.getEstadios(context);
		

		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (EstadioModel e : listaEstadio) {
			stringArray.add(e.getNomeEstadio());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
		
	}
	
}
