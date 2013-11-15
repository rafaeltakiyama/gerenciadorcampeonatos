package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gerenciadordecampeonatos.R;

public class AdapterList extends ArrayAdapter<String>{
	
	private Context context;
	private int textViewResourceId;
	private ArrayList<String> stringArray;

	public AdapterList(Context context, int textViewResourceId, ArrayList<String> stringArray) {
		super(context, textViewResourceId);
		
		this.context = context;
		this.stringArray = stringArray;
		this.textViewResourceId = textViewResourceId;
	}

	@Override
	public int getCount() {
		return stringArray.size();
	}

	@Override
	public String getItem(int position) {
		return stringArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/abc3D.ttf"); 
		
		LayoutInflater inflater = (LayoutInflater)
	            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View view = inflater.inflate(textViewResourceId, null);

		TextView text = (TextView) view.findViewById(R.itemLista.item);
		text.setText(stringArray.get(position));
		text.setTypeface(type);

		return view;
	}

	
}
