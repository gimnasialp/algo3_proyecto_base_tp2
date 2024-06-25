package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class ExclusividadDePuntaje implements Modificador{

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {

        int cantidadJugadoresQueRespondieronBien = puntajeRonda.size();

        for (Integer puntos: puntajeRonda){
            if(puntos == 0) {
                cantidadJugadoresQueRespondieronBien -= 1;
            }
        }

        if (cantidadJugadoresQueRespondieronBien == 1) {
            int i = 0;
            while (i < puntajeRonda.size() && puntajeRonda.get(i) == 0) {
                i++;
            }
            puntajeRonda.set(i, puntajeRonda.get(i)*2);
        }
    }
}
