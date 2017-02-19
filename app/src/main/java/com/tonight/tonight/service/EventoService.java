package com.tonight.tonight.service;

import com.tonight.tonight.domain.Evento;

/**
 * Created by d3jota on 19/02/17.
 */

public class EventoService {

    public Evento cadastroEvento(String nome, String data, String descricao) {
        Evento evento = new Evento(nome, data, descricao);
        return evento;
    }
}
