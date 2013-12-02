package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.AdapterList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.TimeController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaTime extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;

		List<TimeModel> listaTime = new ArrayList<TimeModel>();

		listaTime = TimeController.getTime(context);

		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (TimeModel t : listaTime) {
			stringArray.add(t.getNomeTime());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
	}
	
}
