package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.CampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadePrincipal extends Activity {

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_principal);

		context = this;

		ListView listViewCampeonatos = (ListView) findViewById(R.id.listView1);

		List<CampeonatoModel> listCampeonatos = new ArrayList<CampeonatoModel>();

		listCampeonatos = CampeonatoController.getCampenatos(context);
		

		ArrayAdapter<CampeonatoModel> adapter = new ArrayAdapter<CampeonatoModel>(context,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listCampeonatos);
		
		listViewCampeonatos.setAdapter(adapter)
;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
