package com.tonight.tonight.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tonight.tonight.R;
import com.tonight.tonight.domain.Evento;
import com.tonight.tonight.infra.EventoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    private ListView listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        listaEventos = (ListView) findViewById(R.id.listaEventos);

        Evento evento1 = new Evento("Ibura Rock Festival", "06/06/2017", "Prepare-se para o show de rock mais badalado da periferia. Organizado por Airton Samuel.");
        Evento evento2 = new Evento("Orquestra do Cordeiro toca Chopin 2", "07/07/2017", "Interpretação dos clássicos de Chopin pelo maestro João.");

        List<Evento> items = new ArrayList<Evento>();
        items.add(evento1);
        items.add(evento2);

        EventoListAdapter eventoAdapter = new EventoListAdapter(this, 0, (ArrayList<Evento>) items);

        listaEventos.setAdapter(eventoAdapter);

/*        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Projeto projeto = (Projeto) parent.getAdapter().getItem(position);
                sessao.setProjeto(projeto);

                Intent intent = new Intent(MainActivity.this, ProjetoMainActivity.class);
                //intent.putExtra("nome", projeto.getNome());
                startActivity(intent);
            }
        });*/

    }
}
