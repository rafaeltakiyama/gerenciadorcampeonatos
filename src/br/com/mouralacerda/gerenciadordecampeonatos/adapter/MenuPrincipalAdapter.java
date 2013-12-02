package br.com.mouralacerda.gerenciadordecampeonatos.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerenciadordecampeonatos.R;

public class MenuPrincipalAdapter extends ArrayAdapter<String> {

	private LayoutInflater mInflater;
	private int textViewResourceId;
	private String[] itens;
	private TypedArray icons;
	private Context context;

	public MenuPrincipalAdapter(Context context, int textViewResourceId,
			String[] itens, TypedArray icons) {
		super(context, textViewResourceId);

		this.textViewResourceId = textViewResourceId;
		this.icons = icons;
		this.itens = itens;
		this.context = context;
	}

	@Override
	public int getCount() {
		return itens.length;
	}

	@Override
	public String getItem(int position) {
		return itens[position];
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
	        View view = inflater.inflate(R.layout.layout_item_menu_principal, null);
		

		ImageView icon = (ImageView) view.findViewById(R.itemMenu.img);
		icon.setImageDrawable(icons.getDrawable(position));

		TextView textTitle = (TextView) view.findViewById(R.itemMenu.textTitle);
		textTitle.setText(itens[position]);
		textTitle.setTypeface(type);

		return view;
	}

}
