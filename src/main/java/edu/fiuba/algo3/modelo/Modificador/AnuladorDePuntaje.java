package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class AnuladorDePuntaje extends ModificadorState{

    private final int LIMITE_USO=1;

    public AnuladorDePuntaje(){
        super(0);
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        for (int i = 0; i < puntajeRonda.size(); i++) {
            if (i != jugadorPosicion) {
                puntajeRonda.set(i, 0);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void actualizarCantidadDeUso(){
        vecesUsado++;
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, ArrayList<Jugador> jugadores) {

    }

    @Override
    public boolean habilitado() {
        return false;
    }
}
