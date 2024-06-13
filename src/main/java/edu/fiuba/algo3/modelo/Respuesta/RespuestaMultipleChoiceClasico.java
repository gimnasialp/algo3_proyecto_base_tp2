package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaMultipleChoiceClasico implements Respuesta {

    private final ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceClasico (ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaMultipleChoiceClasico respuestaCorrecta = (RespuestaMultipleChoiceClasico) respuesta;
        return respuestaCorrecta.evaluar(this.respuesta);
    }

    private boolean evaluar(ArrayList<Integer> respuestaJugador) {
        return new HashSet<>(respuestaJugador).equals(new HashSet<>(this.respuesta));
    }
}
