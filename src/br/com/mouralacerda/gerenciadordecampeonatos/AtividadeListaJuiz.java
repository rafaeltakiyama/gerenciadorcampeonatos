package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.AdapterList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JuizController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaJuiz extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;

		List<JuizModel> listaJuiz = new ArrayList<JuizModel>();

		listaJuiz = JuizController.getJuiz(context);
		
		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (JuizModel j : listaJuiz) {
			stringArray.add(j.getNomeJuiz());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
		
	}
	
}
