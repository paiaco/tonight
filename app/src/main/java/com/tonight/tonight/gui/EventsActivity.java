package com.tonight.tonight.gui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    private static List<Evento> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        listaEventos = (ListView) findViewById(R.id.listaEventos);

/*
        Evento evento1 = new Evento("Ibura Rock Festival", "06/06/2017", "Prepare-se para o show de rock mais badalado da periferia. Organizado por Airton Samuel.");
        Evento evento2 = new Evento("Orquestra do Cordeiro toca Chopin 2", "07/07/2017", "Interpretação dos clássicos de Chopin pelo maestro João.");

        items.add(evento1);
        items.add(evento2);
*/

        final EventoListAdapter eventoAdapter = new EventoListAdapter(this, 0, (ArrayList<Evento>) items);

        listaEventos.setAdapter(eventoAdapter);

        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(EventsActivity.this);
                adb.setTitle("Evento");
                adb.setMessage("O que deseja fazer?");
                final int positionToRemove = position;
                adb.setNegativeButton("Compartilhar", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Evento evento = items.get(positionToRemove);
                        returnName(evento);
                    }
                });
                adb.setPositiveButton("Excluir", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        items.remove(positionToRemove);
                        eventoAdapter.notifyDataSetChanged();
                    }});
                adb.show();
            }
        });

    }

    public static void addEvento(Evento ev) {
        items.add(ev);
    }

    public void onButtonClickEvento(View v) {
        if(v.getId() == R.id.buttonTelaCadastroEvento) {
            Intent intent = new Intent(getApplicationContext(), CriaEventoActivity.class);
            startActivity(intent);
        }
    }

    public String returnName(Evento ev) {
        return ev.getNome();
    }


}
