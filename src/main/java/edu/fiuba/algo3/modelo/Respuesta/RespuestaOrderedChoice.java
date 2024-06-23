package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.ArrayList;

public class RespuestaOrderedChoice extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaOrderedChoice(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        RespuestaOrderedChoice respuestaCorrecta = (RespuestaOrderedChoice) respuesta;
        if (respuestaCorrecta.evaluar(this.respuesta)) {
            return this.puntaje.getValorRespuestaCorrecta();
        }
        return this.puntaje.getValorRespuestaIncorrecta();
    }

    public boolean evaluar(ArrayList<Integer> respuesta) {
        return this.respuesta.equals(respuesta);
    }

}