package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.AdapterList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaJogador extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;

		List<JogadorModel> listaJogador = new ArrayList<JogadorModel>();

		listaJogador = JogadorController.getJogador(context);

		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (JogadorModel j : listaJogador) {
			stringArray.add(j.getNomeJogador());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
	}
	
}
