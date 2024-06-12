package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class AnuladorDePuntaje implements Modificador{
    @Override
    public void aplicar(ArrayList<Integer> puntosRonda, int jugadorIndice) {
        for (int i = 0; i < puntosRonda.size(); i++) {
            if (i != jugadorIndice) {
                puntosRonda.set(i, 0);
            }
        }
    }
}
