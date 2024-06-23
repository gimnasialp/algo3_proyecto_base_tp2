package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicadorPorUno implements Modificador{

    private final int MULTIPLICADOR = 2;

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        puntajeRonda.set(jugadorPosicion, puntajeRonda.get(jugadorPosicion)*MULTIPLICADOR);
    }
}
