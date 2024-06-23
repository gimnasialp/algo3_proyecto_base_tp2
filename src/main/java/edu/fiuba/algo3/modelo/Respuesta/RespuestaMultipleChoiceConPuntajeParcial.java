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
        RespuestaMultipleChoiceConPuntajeParcial respuestaCorrecta = (RespuestaMultipleChoiceConPuntajeParcial) respuesta;
        Integer puntos = 0;
        for (Integer opcionElegida : this.respuesta) {
            if (respuestaCorrecta.evaluar(opcionElegida)) {
                puntos += this.puntaje.getValorRespuestaCorrecta();
            }
            else {
                return this.puntaje.getValorRespuestaIncorrecta();
            }
        }
        return puntos;
    }

    public boolean evaluar(Integer opcionElegida) {
        return this.respuesta.contains(opcionElegida);
    }
}