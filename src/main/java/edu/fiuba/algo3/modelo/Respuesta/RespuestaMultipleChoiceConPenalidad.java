package edu.fiuba.algo3.modelo.Respuesta;

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
        RespuestaMultipleChoiceConPenalidad respuestaCorrecta = (RespuestaMultipleChoiceConPenalidad) respuesta;
        Integer puntos = 0;
        for (Integer opcionElegida : this.respuesta) {
            if (respuestaCorrecta.evaluar(opcionElegida)) {
                puntos += this.puntaje.getValorRespuestaCorrecta();
            }
            else {
                puntos += this.puntaje.getValorRespuestaIncorrecta();
            }
        }
        return puntos;
    }

    public boolean evaluar(Integer opcionElegida) {
        return this.respuesta.contains(opcionElegida);
    }
}
