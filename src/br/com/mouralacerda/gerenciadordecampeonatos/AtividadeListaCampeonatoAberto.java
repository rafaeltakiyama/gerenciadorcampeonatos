package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.CustonAdapterCompeonatoExpList;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.PartidaController;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.RodadaController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;
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
		expListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
					int childPosition, long id) {

				   	int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
				
				   	RodadaModel r = new RodadaModel();
				   	
					r = (RodadaModel) (parent.getItemAtPosition(index)); 
					
					showCustomDialog(r.getNumeroRodada(), r.getCampeonatoRodada().getCodCampeonato(), r.getCampeonatoRodada().getNomeCampeonato());
				
				return true;
			}
		});
		
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
	

	private void showCustomDialog(int numeroRodada, int codCamp, String nomeCamp) {

		final Dialog dialog = new Dialog(context);

		dialog.setContentView(R.layout.layout_dialog_mostra_info);
		
		dialog.setTitle("Campeonato "+ nomeCamp);
		
		List<PartidaModel> partidaList = new ArrayList<PartidaModel>();
		partidaList = PartidaController.getPartidas(context);

		final Button ok = (Button) dialog.findViewById(R.dialog.btnOk);
		final TextView time1 = (TextView) dialog.findViewById(R.dialog.time1);
		final TextView time2 = (TextView) dialog.findViewById(R.dialog.time2);
		final TextView nomeEstadio = (TextView) dialog
				.findViewById(R.dialog.nomeEstadio);
		final TextView nomeJuiz = (TextView) dialog
				.findViewById(R.dialog.nomeJuiz);

		for (PartidaModel p : partidaList) {

			if (p.getRodadaPartida().getNumeroRodada() == numeroRodada
					&& codCamp == p.getRodadaPartida().getCampeonatoRodada().getCodCampeonato()) {

				time1.setText(p.getTime1Partida().getNomeTime());
				time2.setText(p.getTime2Partida().getNomeTime());
				nomeEstadio.setText(p.getEstadioPartida().getNomeEstadio());
				nomeJuiz.setText(p.getJuizPartida().getNomeJuiz());
			}

		}

		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// ação do botão ok
				dialog.dismiss();// encerra o dialog
			}
		});
		dialog.show();// mostra o dialog

	}
}
