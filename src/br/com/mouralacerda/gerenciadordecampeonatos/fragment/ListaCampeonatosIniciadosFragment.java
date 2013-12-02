package br.com.mouralacerda.gerenciadordecampeonatos.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import br.com.mouralacerda.gerenciadordecampeonatos.controller.RodadaController;
import br.com.mouralacerda.gerenciadordecampeonatos.model.CampeonatoModel;
import br.com.mouralacerda.gerenciadordecampeonatos.model.RodadaModel;

public class ListaCampeonatosIniciadosFragment extends ListFragment{

	List<CampeonatoModel> campeonatoList;
	List<RodadaModel> rodadaList;
	Context context;
	private HashMap<Integer, Integer> rodadaHash;
	private HashMap<String, Integer> campeonatoHash;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = getActivity();
		
		rodadaList = new ArrayList<RodadaModel>();
		
		rodadaList = RodadaController.getRodadas(context);
		
		rodadaHash = new HashMap<Integer, Integer>();
		
		campeonatoHash = new HashMap<String, Integer>();
		
		for (RodadaModel r : rodadaList) {
			rodadaHash.put(r.getNumeroRodada(), r.getCampeonatoRodada().getCodCampeonato());
			campeonatoHash.put(r.getCampeonatoRodada().getNomeCampeonato(), r.getCampeonatoRodada().getCodCampeonato());
		}
		
		
		
	}
	
	
}
