package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class AnuladorDePuntaje implements Modificador{

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

}
