package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
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
	private Typeface type;
	
	public PartidaListAdapter(Context context, List<PartidaModel> partidaList) {

		this.context = context;
		this.partidaList = partidaList;
		type = Typeface.createFromAsset(context.getAssets(),"fonts/abc3D.ttf");
		
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
	        time1.setTypeface(type);
	        
	        TextView x = (TextView) view.findViewById(R.itemPartida.x);
	        x.setText("X");
	        x.setTypeface(type);
	        
	        TextView time2 = (TextView) view.findViewById(R.itemPartida.time2);
	        time2.setText(partidaModel.getTime2Partida().getNomeTime());
	        time2.setTypeface(type);
	        
	        TextView estadio = (TextView) view.findViewById(R.itemPartida.estadio);
	        estadio.setText("Estádio:");
	        estadio.setTypeface(type);
	        
	        TextView nomeEstadio = (TextView) view.findViewById(R.itemPartida.nomeEstadio);
	        nomeEstadio.setText(partidaModel.getEstadioPartida().getNomeEstadio());
	        nomeEstadio.setTypeface(type);
	        
	        TextView juiz = (TextView) view.findViewById(R.itemPartida.juiz);
	        juiz.setText("Juiz:");
	        juiz.setTypeface(type);
	        
	        TextView nomeJuiz = (TextView) view.findViewById(R.itemPartida.nomeJuiz);
	        nomeJuiz.setText(partidaModel.getJuizPartida().getNomeJuiz());
	        nomeJuiz.setTypeface(type);
		
		
		return view;
	}

}
