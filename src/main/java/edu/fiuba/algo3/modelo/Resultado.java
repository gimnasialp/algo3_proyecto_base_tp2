package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Resultado {
    private ArrayList<Integer> puntajesRonda;

    public Resultado () {
        this.puntajesRonda = new ArrayList<Integer>();
    }

    public void agregarPuntos(boolean laRespuestaEsCorrecta) {
        if (laRespuestaEsCorrecta) {
            puntajesRonda.add(1);
        }
    }

    public int obtenerPuntosJugador(int index) {
        return puntajesRonda.get(index);
    }
}
