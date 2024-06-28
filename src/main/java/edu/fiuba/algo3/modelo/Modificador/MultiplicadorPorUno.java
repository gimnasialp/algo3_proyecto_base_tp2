package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicadorPorUno implements Multiplicador{

    private final int MULTIPLICADOR = 1;

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        puntajeRonda.set(jugadorPosicion, puntajeRonda.get(jugadorPosicion)*MULTIPLICADOR);
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

}
