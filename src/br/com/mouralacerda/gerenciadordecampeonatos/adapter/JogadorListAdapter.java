package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.mouralacerda.gerenciadordecampeonatos.model.JogadorModel;

import com.example.gerenciadordecampeonatos.R;

public class JogadorListAdapter extends BaseAdapter {

	private Context context;
	private List<JogadorModel> jogadorList;
	private Typeface type;
	
	public JogadorListAdapter(Context context, List<JogadorModel> jogadorListAdapter) {

		this.context = context;
		this.jogadorList = jogadorListAdapter;
		type = Typeface.createFromAsset(context.getAssets(),"fonts/abc3D.ttf");
		
	}

	@Override
	public int getCount() {
		return jogadorList.size();
	}

	@Override
	public Object getItem(int position) {
		return jogadorList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		JogadorModel jogadorModel = jogadorList.get(position);
		
		LayoutInflater inflater = (LayoutInflater)
	            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View view = inflater.inflate(R.layout.layout_item_nome_jogador, null);
	        
	        TextView nomeJogador = (TextView) view.findViewById(R.itemJogador.jogador);
	        nomeJogador.setText(jogadorModel.getNomeJogador());
	        nomeJogador.setTypeface(type);
	        
		return view;
	}

}
