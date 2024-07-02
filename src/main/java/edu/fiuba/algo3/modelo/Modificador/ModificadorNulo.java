package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ModificadorNulo extends Modificador {

    public ModificadorNulo() {
        super(0,0);
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, ArrayList<Jugador> jugadores) {
    }


}
