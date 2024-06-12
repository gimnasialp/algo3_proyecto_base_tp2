package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicarPorDos implements Modificador{
    @Override
    public void aplicar(ArrayList<Integer> puntosRonda, int jugadorIndice) {
        puntosRonda.set(jugadorIndice, puntosRonda.get(jugadorIndice)*2);
    }
}
