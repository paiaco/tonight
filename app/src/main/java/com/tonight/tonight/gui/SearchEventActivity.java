package com.tonight.tonight.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.tonight.tonight.R;

public class SearchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
    }

    public void onButtonClickSearchEvento(View v) {
        if(v.getId() == R.id.botaoBuscarPorRaio) {
            Spinner spin = (Spinner) findViewById(R.id.spinGeneroEvento);
            String genero = spin.getSelectedItem().toString();

            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("VALOR", genero);
            startActivity(intent);
        } else if(v.getId() == R.id.botaoBuscarPorNome) {
            EditText ed = (EditText) findViewById(R.id.campoBuscaEventoNome);
            String nomeEvento = ed.getText().toString();

            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("VALOR", nomeEvento);
            startActivity(intent);
        }
    }
}
