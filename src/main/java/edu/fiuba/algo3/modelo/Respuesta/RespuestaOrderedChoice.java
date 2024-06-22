package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.ArrayList;

public class RespuestaOrderedChoice extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaOrderedChoice(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        if (respuesta.evaluar(this.respuesta))
        RespuestaOrderedChoice respuestaJugador = (RespuestaOrderedChoice) respuesta;
        return respuestaJugador.evaluar(this.respuesta);
    }

    private boolean evaluar(ArrayList<Integer> respuesta) {
        return this.respuesta.equals(respuesta);
    }

}