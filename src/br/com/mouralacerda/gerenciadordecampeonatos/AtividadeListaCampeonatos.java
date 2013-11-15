package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.AdapterList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.CampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaCampeonatos extends ListActivity{

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;

		List<CampeonatoModel> listCampeonatos = new ArrayList<CampeonatoModel>();

		listCampeonatos = CampeonatoController.getCampenatos(context);
		
		ArrayList<String> campArray = new ArrayList<String>();
		
		for (CampeonatoModel c : listCampeonatos) {
			campArray.add(c.getNomeCampeonato());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, campArray));
	}
	
}
