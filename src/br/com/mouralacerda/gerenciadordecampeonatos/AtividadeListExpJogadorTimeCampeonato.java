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
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.CustonAdapterJogadorTimeCampeonatoExpList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorTimeCampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeListExpJogadorTimeCampeonato extends Activity {
	
	private List<CampeonatoModel> groupCampeonatoList;
	private List<JogadorTimeCampeonatoModel> childJogTimeCampList;
	private Map<String, List<JogadorTimeCampeonatoModel>> collection;
	private ExpandableListView expListView;

	private Context context;

	private List<JogadorTimeCampeonatoModel> jogTimCampList;
	private HashMap<String, CampeonatoModel> campeonatoHash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_exp_lista_campeonato_aberto);

		context = this;
		
		jogTimCampList = new ArrayList<JogadorTimeCampeonatoModel>();
		jogTimCampList = JogadorTimeCampeonatoController.getJogadorTimeCampeonato(context);

		createGroupList();

		createCollection();

		expListView = (ExpandableListView) findViewById(R.campeonatoAbertoActivity.listaCampeonato);
		CustonAdapterJogadorTimeCampeonatoExpList expListAdapter = new CustonAdapterJogadorTimeCampeonatoExpList(
				context, groupCampeonatoList, collection);
		expListView.setAdapter(expListAdapter);
//		expListView.setOnChildClickListener(new OnChildClickListener() {
//
//			@Override
//			public boolean onChildClick(ExpandableListView parent, View v,
//					int groupPosition, int childPosition, long id) {
//
//				int index = parent.getFlatListPosition(ExpandableListView
//						.getPackedPositionForChild(groupPosition, childPosition));
//
//				RodadaModel r = new RodadaModel();
//
//				r = (RodadaModel) (parent.getItemAtPosition(index));
//
//				showCustomDialog(r.getNumeroRodada(), r.getCampeonatoRodada()
//						.getCodCampeonato(), r.getCampeonatoRodada()
//						.getNomeCampeonato());
//
//				return true;
//			}
//		});

	}

	private List<CampeonatoModel> createGroupList() {


		campeonatoHash = new HashMap<String, CampeonatoModel>();
		groupCampeonatoList = new ArrayList<CampeonatoModel>();

		for (JogadorTimeCampeonatoModel j : jogTimCampList) {
			// pego o nome dos campeonatos e seus respectivos codigos.
			campeonatoHash.put(j.getCampeonato().getNomeCampeonato(),
					j.getCampeonato());
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

	private Map<String, List<JogadorTimeCampeonatoModel>> createCollection() {

		collection = new LinkedHashMap<String, List<JogadorTimeCampeonatoModel>>();

		for (CampeonatoModel c : groupCampeonatoList) {

			childJogTimeCampList = new ArrayList<JogadorTimeCampeonatoModel>();

			for (JogadorTimeCampeonatoModel r : jogTimCampList) {
				if (c.getCodCampeonato() == r.getCampeonato()
						.getCodCampeonato()) {
					childJogTimeCampList.add(r);
				}
			}
			collection.put(c.getNomeCampeonato(), childJogTimeCampList);
		}

		return collection;

	}

//	private void showCustomDialog(int numeroRodada, int codCamp, String nomeCamp) {
//
//		AlertDialog.Builder builder = new AlertDialog.Builder(context);
//		builder.setTitle("Campeonato " + nomeCamp);
//		builder.setPositiveButton("OK", null);
//
//		List<PartidaModel> partidaList = new ArrayList<PartidaModel>();
//		partidaList = PartidaController.getPartidas(context);
//
//		List<PartidaModel> partidaListAdapter = new ArrayList<PartidaModel>();
//
//		for (PartidaModel p : partidaList) {
//
//			if (p.getRodadaPartida().getNumeroRodada() == numeroRodada
//					&& codCamp == p.getRodadaPartida().getCampeonatoRodada()
//							.getCodCampeonato()) {
//
//				partidaListAdapter.add(p);
//
//			}
//
//		}
//		
//		ListView list = new ListView(context);
//		PartidaListAdapter partidaAdapter = new PartidaListAdapter(context,
//				partidaListAdapter);
//		list.setAdapter(partidaAdapter);
//
//		list.setBackgroundColor(Color.WHITE);
//		builder.setView(list);
//		Dialog dialog = builder.create();
//
//		dialog.show();
//	}

	
}
