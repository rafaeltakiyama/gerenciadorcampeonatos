package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorTimeCampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.PartidaController;
import br.com.mouralacerda.gerenciadordecampeonatos.dao.DaoFactory;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadePrincipal extends ListActivity {

	private static final String[] nomes = new String[] { "Campeonatos",
			"Est�dios",
			"Jogadores", 
			"Juizes", 
			"Times",
			// "Gerenciar Campeonato",
			"Campeonatos Abertos", 
			"Jogador-Time-Campeonato",
//			"Jogador-Time-Campeonato 2", 
			"Sair" };
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.layout_atividade_principal);

		context = this;

		DaoFactory.init(context);

		this.setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomes));

		List<JogadorTimeCampeonatoModel> jtcModel = new ArrayList<JogadorTimeCampeonatoModel>();

		jtcModel = JogadorTimeCampeonatoController
				.getJogadorTimeCampeonato(context);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
			startActivity(new Intent(this, AtividadeListaCampeonatos.class));
			break;

		case 1:
			startActivity(new Intent(this, AtividadeListaEstadios.class));
			break;

		case 2:
			startActivity(new Intent(this, AtividadeListaJogador.class));
			break;

		case 3:
			startActivity(new Intent(this, AtividadeListaJuiz.class));
			break;

		case 4:
			startActivity(new Intent(this, AtividadeListaTime.class));
			break;

		// case 5:
		// startActivity(new Intent(this, AtividadeGerenciaCampeonato.class));
		// break;

		case 5:
			startActivity(new Intent(this, AtividadeListaCampeonatoAberto.class));
			break;

//		case 6:
//			startActivity(new Intent(this,
//					AtividadeListaJogadorTimeCampeonato.class));
//			break;

		case 6:
			startActivity(new Intent(this,
					AtividadeListExpJogadorTimeCampeonato.class));
			break;
		default:
			finish();
		}
	}

}
