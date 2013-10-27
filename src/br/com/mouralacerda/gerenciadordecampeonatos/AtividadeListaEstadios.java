package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.EstadioController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.EstadioModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaEstadios extends Activity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_atividade_lista_estadio);

		context = this;

		ListView listViewEstadios = (ListView) findViewById(R.estadioActivity.listaEstadio);

		List<EstadioModel> listaEstadio = new ArrayList<EstadioModel>();

		listaEstadio = EstadioController.getEstadios(context);

		ArrayAdapter<EstadioModel> adapter = new ArrayAdapter<EstadioModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listaEstadio);
		
		listViewEstadios.setAdapter(adapter);
		
	}
	
}
