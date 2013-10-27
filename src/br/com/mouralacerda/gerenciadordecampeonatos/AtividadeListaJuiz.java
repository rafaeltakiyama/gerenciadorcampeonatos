package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorController;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JuizController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JuizModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaJuiz extends Activity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_atividade_lista_juiz);

		context = this;

		ListView listViewJuiz = (ListView) findViewById(R.juizActivity.listaJuiz);

		List<JuizModel> listaJuiz = new ArrayList<JuizModel>();

		listaJuiz = JuizController.getJuiz(context);

		ArrayAdapter<JuizModel> adapter = new ArrayAdapter<JuizModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listaJuiz);
		
		listViewJuiz.setAdapter(adapter);
		
	}
	
}
