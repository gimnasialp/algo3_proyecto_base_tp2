package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Resultado {
    protected ArrayList<Integer> puntosRonda;

    public Resultado () {
        this.puntosRonda = new ArrayList<Integer>();
    }

    public void agregarPuntos(int puntos) {
        puntosRonda.add(puntos);
    };

    public int obtenerPuntosDelJugador(int index) {
        return puntosRonda.get(index);
    };
}
