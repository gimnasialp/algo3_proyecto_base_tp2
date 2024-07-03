package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaOrderedChoice implements Respuesta {

    private final ArrayList<Integer> respuesta;

    public RespuestaOrderedChoice(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaOrderedChoice respuestaJugador = (RespuestaOrderedChoice) respuesta;
        return respuestaJugador.evaluar(this.respuesta);
    }

    private boolean evaluar(ArrayList<Integer> respuesta) {
        return this.respuesta.equals(respuesta);
    }
    public ArrayList<Integer> getRespuesta() {
        return respuesta;
    }

}
