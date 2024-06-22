package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntajePenalidad;

import java.util.ArrayList;

public class RespuestaMultipleChoiceConPenalidad extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceConPenalidad(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajePenalidad();
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        Integer puntos = 0;
        for (Integer respuestaElegida : this.respuesta) {
            if (respuesta.evaluar(respuestaElegida)) {
                puntos += this.puntaje.getValorRespuestaCorrecta();
            }
            else {
                puntos += this.puntaje.getValorRespuestaIncorrecta();
            }
        }
        return puntos;
    }

    public boolean evaluar(Integer respuestaElegida) {
        return this.respuesta.contains(respuestaElegida);
    }
}
