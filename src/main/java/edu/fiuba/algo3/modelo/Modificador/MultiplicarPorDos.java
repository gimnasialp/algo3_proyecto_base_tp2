package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicarPorDos implements Modificador{

    private final int MULTIPLICADOR = 2;

    @Override
    public void aplicar(ArrayList<Integer> puntosRonda, int jugadorIndice) {
        puntosRonda.set(jugadorIndice, puntosRonda.get(jugadorIndice)*MULTIPLICADOR);
    }
}
