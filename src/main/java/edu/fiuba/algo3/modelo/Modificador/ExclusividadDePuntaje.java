package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class ExclusividadDePuntaje implements Modificador{
    @Override
    public void aplicar(ArrayList<Integer> puntosRonda, int jugadorIndice) {
        int cantidadJugadoresQueRespondieronBien = puntosRonda.size();
        for (Integer puntos: puntosRonda){
            if(puntos == 0) {
                cantidadJugadoresQueRespondieronBien -= 1;
            }
        }
        if (cantidadJugadoresQueRespondieronBien == 1) {
            int i = 0;
            while (i < puntosRonda.size() && puntosRonda.get(i) == 0) {
                i++;
            }
            puntosRonda.set(i, puntosRonda.get(i)*2);
        }
    }
}
