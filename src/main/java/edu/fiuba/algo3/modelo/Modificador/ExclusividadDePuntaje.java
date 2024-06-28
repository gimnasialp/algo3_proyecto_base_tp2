package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ExclusividadDePuntaje implements Modificador,ModificadorState{

    private int vecesUsado;

    private final int MAXIMO_USO=2;

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

        //actualizarRonda(puntajeRonda);

    }
/*
    private void actualizarRonda(ArrayList<Integer> puntajeRonda) {
        int contestaronBien = (int) puntajeRonda.stream().filter(p->p!=0).count();
        boolean rompeExclusividad = contestaronBien != 1 ;
        if(rompeExclusividad){
            for(int i=0; i<puntajeRonda.size();i++){
                puntajeRonda.set(i,0);
            }
        }
        int i=0;
    }
*/

    @Override
    public boolean equals(Object other) {
        return (this.getClass().equals(other.getClass()))
                && (vecesUsado <= MAXIMO_USO);
    }

    @Override
    public void aplicarState(ModificadorContextState modificadorContextState, ArrayList<Integer> puntajePartida, int jugadorPosicion) {
        modificadorContextState.aplicarState(puntajePartida,  jugadorPosicion);
    }
}
