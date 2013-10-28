package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.TimeController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaTime extends Activity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_atividade_lista_time);

		context = this;

		ListView listViewTime = (ListView) findViewById(R.timeActivity.listaTime);

		List<TimeModel> listaTime = new ArrayList<TimeModel>();

		listaTime = TimeController.getTime(context);

		ArrayAdapter<TimeModel> adapter = new ArrayAdapter<TimeModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listaTime);
		
		listViewTime.setAdapter(adapter);
		
	}
	
}
