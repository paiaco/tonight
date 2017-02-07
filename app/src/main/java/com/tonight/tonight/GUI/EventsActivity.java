package com.tonight.tonight.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tonight.tonight.R;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {

    private ListView listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        listaEventos = (ListView) findViewById(R.id.listaEventos);

        List<String> items = new ArrayList<String>();
        items.add("Show de Rock");
        items.add("Musical");
        items.add("Peça de Teatro");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listaEventos.setAdapter(arrayAdapter);

    }
}
