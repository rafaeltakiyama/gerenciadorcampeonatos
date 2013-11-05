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

	//	String nameCameponato = null;
		// CampeonatoModel c = new CampeonatoModel();
//		for (int i = 0; i < groupCampeonatoList.size(); i++) {
//			c = groupCampeonatoList.get(i);
//
//			// for (RodadaModel r : rodadaList) {
//			// if (c.getCodCampeonato() == r.getCampeonatoRodada()
//			// .getCodCampeonato()) {
//			// childRodadaList.add(r);
//			// nameCameponato = c.getNomeCampeonato();
//			// }
//			// }
//			collection.put(nameCameponato, childRodadaList);
//		}

		int i = 0;
		RodadaModel r = new RodadaModel();
		r = rodadaList.get(i);
		for (CampeonatoModel c : groupCampeonatoList) {
			
			childRodadaList = new ArrayList<RodadaModel>();
			i = 0;
			while (c.getCodCampeonato() == r.getCampeonatoRodada()
					.getCodCampeonato() && i <= rodadaList.size()) {
				childRodadaList.add(r);
				i++;
				r = rodadaList.get(i); //testar tirar a comparacao do cod e deixar apenas a do size
			}
			collection.put(c.getNomeCampeonato(), childRodadaList);
		}

		return collection;

	}
}
