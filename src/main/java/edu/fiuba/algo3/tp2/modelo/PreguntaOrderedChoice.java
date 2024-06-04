package edu.fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class PreguntaOrderedChoice {

    private final String enunciado;
    private final List<String> opciones;
    private RespuestaOrderedChoice respuestaCorrecta;

    public PreguntaOrderedChoice(String enunciado, List<String> opciones, List<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaOrderedChoice(opcionesCorrectas);
    }

    public List<Integer> responder(List<RespuestaOrderedChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaOrderedChoice respuestaUsuario : respuestas) {
            puntos.add(this.respuestaCorrecta.evaluar(respuestaUsuario));
        }
        return puntos;
    }

}
