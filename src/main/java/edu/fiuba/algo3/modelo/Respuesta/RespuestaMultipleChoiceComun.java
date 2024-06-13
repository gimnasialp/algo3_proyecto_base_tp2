package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaMultipleChoiceComun implements Respuesta {

    private final ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceComun (ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaMultipleChoiceComun respuestaCorrecta = (RespuestaMultipleChoiceComun) respuesta;
        return respuestaCorrecta.evaluar(this.respuesta);
    }

    private boolean evaluar(ArrayList<Integer> respuestaJugador) {
        return new HashSet<>(respuestaJugador).equals(new HashSet<>(this.respuesta));
    }
}
