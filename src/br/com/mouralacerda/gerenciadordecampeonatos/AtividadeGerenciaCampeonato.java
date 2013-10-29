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
	private HashMap<Integer, Integer> rodadaHash;
	private ArrayList<String> campeonatoArray;
	private ArrayList<String> rodadaArray;
	private int codCampeonato;

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
		
		spinnerCampeonato.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				add(parent, position);
				
			}

			private void add(AdapterView<?> parent, int position) {
				if(!(parent.getItemAtPosition(position).toString().equals("Selecione..."))){
					
					String campeonatoKey = parent.getItemAtPosition(position).toString();
					
					
					codCampeonato = campeonatoHash.get(campeonatoKey);
					
					spinnerRodada();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
	}

	protected void spinnerRodada() {
		
		List<RodadaModel> rodadaList = new ArrayList<RodadaModel>();
		rodadaList = RodadaController.getRodadas(context);
		
		RodadaModel rodadaModel = new RodadaModel();
		
		rodadaHash = new HashMap<Integer, Integer>();
		
		rodadaArray = new ArrayList<String>();
		rodadaArray.add("Selecione...");

		if(rodadaList != null){
			int tamanho = rodadaList.size() + 1;
			rodadaArray.add("Rodada " + tamanho + 1);
			rodadaModel.setCodCampeonatoRodada(codCampeonato);
			rodadaList.add(rodadaModel);
			RodadaController.salvarRodada(context, rodadaList);
			
			for (RodadaModel r : rodadaList) {
				rodadaHash.put(r.getCodRodada(), r.getCodCampeonatoRodada());
			}
			
		}else{
			rodadaArray.add("Rodada " + 1);
//			rodadaModel.setCodCampeonatoRodada(codCampeonato);
//			rodadaModel.setCodRodada(1);
//			rodadaList.set(0, rodadaModel);
//			RodadaController.salvarRodada(context, rodadaList);
		}
		
		Spinner spinnerRod = (Spinner) findViewById(R.gereciaActivity.spinnerRodada);
		ArrayAdapter<String> rodadaAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, rodadaArray);
		spinnerRod.setAdapter(rodadaAdapter);
	}
}
