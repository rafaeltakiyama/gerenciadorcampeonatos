package br.com.mouralacerda.gerenciadordecampeonatos;

import com.example.gerenciadordecampeonatos.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AtividadePrincipal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_principal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
