package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaJogador extends Activity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_atividade_lista_jogador);

		context = this;

		ListView listViewJogador = (ListView) findViewById(R.jogadorActivity.listaJogador);

		List<JogadorModel> listaJogador = new ArrayList<JogadorModel>();

		listaJogador = JogadorController.getJogador(context);

		ArrayAdapter<JogadorModel> adapter = new ArrayAdapter<JogadorModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listaJogador);
		
		listViewJogador.setAdapter(adapter);
		
	}
	
}
