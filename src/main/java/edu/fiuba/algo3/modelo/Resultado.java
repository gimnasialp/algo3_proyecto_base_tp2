package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Modificador.Modificador;

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

    public void usarModificador(Modificador modificador, int jugadorIndice) {
        modificador.aplicar(puntosRonda, jugadorIndice);
    }
}
