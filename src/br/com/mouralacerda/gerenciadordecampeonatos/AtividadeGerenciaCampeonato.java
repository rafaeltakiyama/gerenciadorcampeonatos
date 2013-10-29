package br.com.mouralacerda.gerenciadordecampeonatos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.gerenciadordecampeonatos.R;

public class AtividadeGerenciaCampeonato extends Activity {

	Context context;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_gerencia_campeonato);

		context = this;

	}
	
}
