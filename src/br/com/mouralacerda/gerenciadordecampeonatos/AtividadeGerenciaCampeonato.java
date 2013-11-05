package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.CampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.RodadaController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

import com.example.gerenciadordecampeonatos.R;

@SuppressLint("UseSparseArrays")
public class AtividadeGerenciaCampeonato extends Activity {

	private Context context;
	private HashMap<String, Integer> campeonatoHash;
	private ArrayList<String> campeonatoArray;
	private int codCampeonato;

	private ArrayList<String> rodadaArray;
	private List<RodadaModel> rodadaList;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_gerencia_campeonato);

		context = this;

		List<CampeonatoModel> campeonatoList = CampeonatoController
				.getCampenatos(context);

		campeonatoHash = new HashMap<String, Integer>();
		campeonatoArray = new ArrayList<String>();
		campeonatoArray.add("Selecione...");

		for (CampeonatoModel campeonato : campeonatoList) {
			campeonatoHash.put(campeonato.getNomeCampeonato(),
					campeonato.getCodCampeonato());
			campeonatoArray.add(campeonato.getNomeCampeonato());
		}

		spinnerCampeonato(campeonatoHash);
	}

	private void spinnerCampeonato(HashMap<String, Integer> campeonatoHash2) {

		Spinner spinnerCampeonato = (Spinner) findViewById(R.gereciaActivity.spinnerCampeonato);
		ArrayAdapter<String> adapterCampeonato = new ArrayAdapter<String>(
				context, android.R.layout.simple_spinner_item, campeonatoArray);
		spinnerCampeonato.setAdapter(adapterCampeonato);

		spinnerCampeonato
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {

						add(parent, position);

					}

					private void add(AdapterView<?> parent, int position) {
						if (!(parent.getItemAtPosition(position).toString()
								.equals("Selecione..."))) {

							String campeonatoKey = parent.getItemAtPosition(
									position).toString();

							codCampeonato = campeonatoHash.get(campeonatoKey);

							btnRodada(campeonatoKey);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});

	}

	protected void btnRodada(String campeonatoKey) {
		
		Button btnRodada = (Button) findViewById(R.gereciaActivity.btnRodada);
		
		rodadaList = new ArrayList<RodadaModel>();
		
		rodadaList = RodadaController.getRodadas(context);
		
		if(rodadaList != null){
			
			Toast.makeText(context, "O campeonato " + campeonatoKey + " já foi iniciado!", Toast.LENGTH_SHORT).show();
			
			int numRodada = rodadaList.size() + 1;
			btnRodada.setText("Rodada " + numRodada);
			btnRodada.setVisibility(View.VISIBLE);
		}else{
			btnRodada.setText("Rodada 1");
			btnRodada.setVisibility(View.VISIBLE);
		}
		
	}
}
