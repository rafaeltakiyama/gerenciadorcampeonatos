package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.mouralacerda.gerenciadordecampeonatos.model.PartidaModel;

import com.example.gerenciadordecampeonatos.R;

public class PartidaListAdapter extends BaseAdapter {

	private Context context;
	private List<PartidaModel> partidaList;
	
	public PartidaListAdapter(Context context, List<PartidaModel> partidaList) {

		this.context = context;
		this.partidaList = partidaList;
		
	}

	@Override
	public int getCount() {
		return partidaList.size();
	}

	@Override
	public Object getItem(int position) {
		return partidaList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		PartidaModel partidaModel = partidaList.get(position);
		
		LayoutInflater inflater = (LayoutInflater)
	            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View view = inflater.inflate(R.layout.layout_item_partida, null);
	        
	        TextView time1 = (TextView) view.findViewById(R.itemPartida.time1);
	        time1.setText(partidaModel.getTime1Partida().getNomeTime());
	        
	        TextView time2 = (TextView) view.findViewById(R.itemPartida.time2);
	        time2.setText(partidaModel.getTime2Partida().getNomeTime());
	        
	        TextView nomeEstadio = (TextView) view.findViewById(R.itemPartida.nomeEstadio);
	        nomeEstadio.setText(partidaModel.getEstadioPartida().getNomeEstadio());
	        
	        TextView nomeJuiz = (TextView) view.findViewById(R.itemPartida.nomeJuiz);
	        nomeJuiz.setText(partidaModel.getJuizPartida().getNomeJuiz());
		
		
		return view;
	}

}
