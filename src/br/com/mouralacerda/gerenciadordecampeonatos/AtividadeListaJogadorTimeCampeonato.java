package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorTimeCampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaJogadorTimeCampeonato extends Activity{

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_lista_jogador_time_campeonato);

		context = this;

		ListView listViewCampeonatos = (ListView) findViewById(R.campeonatoTimeJogActivity.listaCampeonatoTimeJog);

		List<JogadorTimeCampeonatoModel> listJogadorTimeCampeonato = new ArrayList<JogadorTimeCampeonatoModel>();

		listJogadorTimeCampeonato = JogadorTimeCampeonatoController.getJogadorTimeCampeonato(context);
		

		ArrayAdapter<JogadorTimeCampeonatoModel> adapter = new ArrayAdapter<JogadorTimeCampeonatoModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listJogadorTimeCampeonato);
		
		listViewCampeonatos.setAdapter(adapter);
	}
	
}
