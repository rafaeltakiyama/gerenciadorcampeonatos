package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.ExpandableListView;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.CustonAdapterCompeonatoExpList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.RodadaController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListaCampeonatoAberto extends Activity {

	private List<CampeonatoModel> groupCampeonatoList;
	private List<RodadaModel> childRodadaList;
	private Map<String, List<RodadaModel>> collection;
	private ExpandableListView expListView;

	private Context context;

	private List<RodadaModel> rodadaList;
	private HashMap<String, CampeonatoModel> campeonatoHash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_lista_campeonato_aberto);

		context = this;

		createGroupList();

		createCollection();

		expListView = (ExpandableListView) findViewById(R.campeonatoAbertoActivity.listaCampeonato);
		CustonAdapterCompeonatoExpList expListAdapter = new CustonAdapterCompeonatoExpList(
				context, groupCampeonatoList, collection);
		expListView.setAdapter(expListAdapter);

	}

	private List<CampeonatoModel> createGroupList() {

		rodadaList = new ArrayList<RodadaModel>();
		rodadaList = RodadaController.getRodadas(context);

		campeonatoHash = new HashMap<String, CampeonatoModel>();
		groupCampeonatoList = new ArrayList<CampeonatoModel>();

		for (RodadaModel r : rodadaList) {
			// pego o nome dos campeonatos e seus respectivos codigos.
			campeonatoHash.put(r.getCampeonatoRodada().getNomeCampeonato(),
					r.getCampeonatoRodada());
		}

		String campeonatoKey;
		Iterator i = campeonatoHash.keySet().iterator();
		while (i.hasNext()) {
			campeonatoKey = String.valueOf(i.next());
			groupCampeonatoList.add(campeonatoHash.get(campeonatoKey));
		}

		Collections.reverse(groupCampeonatoList);

		return groupCampeonatoList;

	}

	private Map<String, List<RodadaModel>> createCollection() {

		rodadaList = new ArrayList<RodadaModel>();
		rodadaList = RodadaController.getRodadas(context);

		collection = new LinkedHashMap<String, List<RodadaModel>>();

		for (CampeonatoModel c : groupCampeonatoList) {
			
			childRodadaList = new ArrayList<RodadaModel>();

			for(RodadaModel ro : rodadaList){
				if(c.getCodCampeonato() == ro.getCampeonatoRodada().getCodCampeonato()){
					childRodadaList.add(ro);
				}
			}
			collection.put(c.getNomeCampeonato(), childRodadaList);
		}

		return collection;

	}
}
