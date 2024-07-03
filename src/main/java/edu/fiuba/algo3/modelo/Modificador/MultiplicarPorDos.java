package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicarPorDos implements Multiplicador {

    private final int MULTIPLICADOR = 2;

    // private int usado =0;

    //  private final int limite =1;

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        puntajeRonda.set(jugadorPosicion, puntajeRonda.get(jugadorPosicion) * MULTIPLICADOR);
        //  ++usado;
    }

    @Override
    public int consultarValor() {
        return MULTIPLICADOR;
    }
/*
    public boolean tieneMultiplicadorActivo(){
        return  limite<usado;
    }*/

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }


}
