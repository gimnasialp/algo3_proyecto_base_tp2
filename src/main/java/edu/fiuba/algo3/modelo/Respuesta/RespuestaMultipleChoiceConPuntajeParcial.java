package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.ArrayList;

public class RespuestaMultipleChoiceConPuntajeParcial extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceConPuntajeParcial(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        Integer puntos = 0;
        for (Integer respuestaElegida : this.respuesta) {
            if (respuesta.evaluar(respuestaElegida)) {
                puntos += this.puntaje.getValorRespuestaCorrecta();
            }
            else {
                return this.puntaje.getValorRespuestaIncorrecta();
            }
        }
        return puntos;
    }

    public boolean evaluar(Integer respuestaElegida) {
        return this.respuesta.contains(respuestaElegida);
    }
}