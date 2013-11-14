package br.com.mouralacerda.gerenciadordecampeonatos;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import br.com.mouralacerda.gerenciadordecampeonatos.adapter.MenuPrincipalAdapter;

import com.example.gerenciadordecampeonatos.R;

public class AtividadePrincipalIcon extends ListActivity {

	
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	//	setContentView(R.layout.layout_atividade_principal);
		
		context = this;
		
		Resources res = context.getResources();
		
		String[] itens = res.getStringArray(R.array.itens_menu);
		TypedArray icons = res.obtainTypedArray(R.array.itens_ico);
		
		setListAdapter(new MenuPrincipalAdapter(context, R.layout.layout_item_menu_principal, itens, icons));

	}
}
