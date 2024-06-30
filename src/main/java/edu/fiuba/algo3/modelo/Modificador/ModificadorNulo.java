package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ModificadorNulo extends ModificadorState {

    public ModificadorNulo() {
        super(0);
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
    }

    @Override
    public void actualizarCantidadDeUso() {
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, ArrayList<Jugador> jugadores) {

    }

    @Override
    public boolean habilitado() {
        return false;
    }


}
