package com.tonight.tonight.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tonight.tonight.R;

import com.tonight.tonight.service.EventoService;

public class CriaEventoActivity extends AppCompatActivity {

    private EventoService evService = new EventoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_evento);
    }

    public void onButtonClickEvento(View v) {
        if(v.getId() == R.id.botaoCadastroEvento) {
            EditText nome = (EditText) findViewById(R.id.campoCadastroNomeEvento);
            EditText data = (EditText) findViewById(R.id.campoCadastroDataEvento);
            EditText descricao = (EditText) findViewById(R.id.campoCadastroDescricaoEvento);

            String nomeString = nome.getText().toString();
            String dataString = data.getText().toString();
            String descricaoString = descricao.getText().toString();

            EventsActivity.addEvento(evService.cadastroEvento(nomeString, dataString, descricaoString));

            Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
            startActivity(intent);
        }
    }
}
