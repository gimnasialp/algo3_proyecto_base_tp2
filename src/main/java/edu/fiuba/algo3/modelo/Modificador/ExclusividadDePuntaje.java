package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ExclusividadDePuntaje implements ModificadorState{

    private int vecesUsado;

    public ExclusividadDePuntaje(){
        this.vecesUsado =0;
    }
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

    @Override
    public boolean equals(Object other) {
        return (this.getClass().equals(other.getClass()));
    }

    @Override
    public void actualizarCantidadDeUso(){
        vecesUsado++;
    }



}
