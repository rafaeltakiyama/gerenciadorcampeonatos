package br.com.mouralacerda.gerenciadordecampeonatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.CustonAdapterJogadorTimeCampeonatoExpList;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.JogadorListAdapter;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorController;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.JogadorTimeCampeonatoController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorTimeCampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.TimeModel;

import com.example.gerenciadordecampeonatos.R;
import com.example.gerenciadordecampeonatos.R.groupCampeonato;

public class AtividadeListExpJogadorTimeCampeonato extends Activity {

	private List<CampeonatoModel> groupCampeonatoList;
	private List<JogadorTimeCampeonatoModel> childJogTimeCampList;
//	private Map<String, List<JogadorTimeCampeonatoModel>> collection;
	HashMap<String, List<String>> collection;
	private ExpandableListView expListView;

	private Context context;

	private List<JogadorTimeCampeonatoModel> jogTimCampList;
	private HashMap<String, CampeonatoModel> campeonatoHash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_exp_lista_campeonato_aberto);

		context = this;
		
		Toast.makeText(context, "Selecione o time para visualizar os jogadores!", Toast.LENGTH_LONG).show();

		jogTimCampList = new ArrayList<JogadorTimeCampeonatoModel>();
		jogTimCampList = JogadorTimeCampeonatoController
				.getJogadorTimeCampeonato(context);

		createGroupList();

		createCollection();

		DisplayMetrics metrics = new DisplayMetrics();

		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;

		expListView = (ExpandableListView) findViewById(R.campeonatoAbertoActivity.listaCampeonato);

		expListView.setIndicatorBounds(width - GetDipsFromPixel(50), width
				- GetDipsFromPixel(5));
		expListView.setGroupIndicator(getResources().getDrawable(
				R.drawable.group_indicator));

		final CustonAdapterJogadorTimeCampeonatoExpList expListAdapter = new CustonAdapterJogadorTimeCampeonatoExpList(
				context, groupCampeonatoList, collection);

		expListView.setAdapter(expListAdapter);

		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				int index = parent.getFlatListPosition(ExpandableListView
						.getPackedPositionForChild(groupPosition, childPosition));

				String time = (String) (parent.getItemAtPosition(index));
				
				String camp = (String) expListAdapter.getGroup(groupPosition);
				
				showCustomDialog(time, camp);

				return true;
			}
		});
	}

	private void showCustomDialog(String time, String camp) {

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(camp);
		builder.setPositiveButton("OK", null);

		List<JogadorTimeCampeonatoModel> jtcList = new ArrayList<JogadorTimeCampeonatoModel>();
		jtcList = JogadorTimeCampeonatoController.getJogadorTimeCampeonato(context);

		List<JogadorModel> jogadorListAdapter = new ArrayList<JogadorModel>();

		for (JogadorTimeCampeonatoModel jtc : jtcList) {

			if (jtc.getCampeonato().getNomeCampeonato().equals(camp) 
					&& jtc.getTime().getNomeTime().equals(time)) {
				jogadorListAdapter.add(jtc.getJogador());
			}

		}
		
		ListView list = new ListView(context);
		JogadorListAdapter jogadorAdapter = new JogadorListAdapter(context,
				jogadorListAdapter);
		list.setAdapter(jogadorAdapter);

		list.setBackgroundColor(Color.WHITE);
		builder.setView(list);
		Dialog dialog = builder.create();

		dialog.show();
	}

	// Convert pixel to dip
	public int GetDipsFromPixel(float pixels) {
		// Get the screen's density scale
		final float scale = getResources().getDisplayMetrics().density;
		// Convert the dps to pixels, based on density scale
		return (int) (pixels * scale + 0.5f);
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

	private Map<String, List<String>> createCollection() {
		
		
		collection = new HashMap<String, List<String>>();
		HashMap<String, Integer> child ;
		
		
		for (CampeonatoModel c : groupCampeonatoList) {
			child = new HashMap<String, Integer>();
			
			for (JogadorTimeCampeonatoModel jtc : jogTimCampList) {
				if (c.getCodCampeonato() == jtc.getCampeonato().getCodCampeonato()) {
					
					child.put(jtc.getTime().getNomeTime(), jtc.getCampeonato().getCodCampeonato());
				}
				
				List<String> childList = new ArrayList<String>();
				
				Iterator i = child.keySet().iterator();
				while(i.hasNext()){
					childList.add(String.valueOf(i.next()));
				}
				
				
				collection.put(c.getNomeCampeonato(), childList);
			}
			
		}
				
		
		
		

//		collection = new LinkedHashMap<String, List<JogadorTimeCampeonatoModel>>();
//
//		for (CampeonatoModel c : groupCampeonatoList) {
//
//			childJogTimeCampList = new ArrayList<JogadorTimeCampeonatoModel>();
//
//			for (JogadorTimeCampeonatoModel jtc : jogTimCampList) {
//				if (c.getCodCampeonato() == jtc.getCampeonato().getCodCampeonato()) {
//						childJogTimeCampList.add(jtc);
//				}
//			}
//			collection.put(c.getNomeCampeonato(), childJogTimeCampList);
//		}
		return collection;
	}

}
