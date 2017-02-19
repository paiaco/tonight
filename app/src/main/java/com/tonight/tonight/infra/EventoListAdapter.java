package com.tonight.tonight.infra;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tonight.tonight.R;
import com.tonight.tonight.domain.Evento;

import java.util.ArrayList;

/**
 * Created by d3jota on 19/02/17.
 */

public class EventoListAdapter extends ArrayAdapter<Evento> {
    private Activity activity;
    private ArrayList<Evento> listaEventos;
    private static LayoutInflater inflater = null;

    public EventoListAdapter (Activity activity, int textViewResourceId, ArrayList<Evento> _listaEventos){
        super(activity, textViewResourceId, _listaEventos);
        try {
            this.activity = activity;
            this.listaEventos = _listaEventos;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e){

        }
    }

    public int getCount() {
        return listaEventos.size();
    }

    public Evento getItem(Evento position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView nome_evento;
        public TextView data_evento;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.padrao_lista_evento, null);
                holder = new ViewHolder();
                holder.nome_evento = (TextView) vi.findViewById(R.id.nome_evento);
                holder.data_evento = (TextView) vi.findViewById(R.id.data_evento);
                vi.setTag(holder);

            } else {
                holder = (ViewHolder) vi.getTag();
            }
            holder.nome_evento.setText(listaEventos.get(position).getNome());
            holder.data_evento.setText(listaEventos.get(position).getData());

        } catch (Exception e) {

        }
        return vi;
    }


}
