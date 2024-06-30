package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ModificadorContextState {

    private ModificadorState actualModificadorState;

    public ModificadorContextState(){
        this.actualModificadorState = new ModificadorNulo();
    }

    public void setState(ModificadorState state){
        actualModificadorState = state;
    }

    public ModificadorState getState(){
        return actualModificadorState;
    }
    public void aplicarState( ArrayList<Integer> puntajePartida, int jugadorPosicio){
        actualModificadorState.aplicar(puntajePartida,jugadorPosicio);
    }

    /*
    public ModificadorState modificadorGanador(List<Jugador> jugadorList){
        int anuladorCount = (int) jugadorList.stream().filter(
                                        m->m.obtenerModificadorActual().equals(AnuladorDePuntaje.class)).count();

        if(anuladorCount == 0 & exclusividadCount==0){
            return new ModificadorNulo();
        }else{
            return getExclusivoOrAnulador(anuladorCount, exclusividadCount);
        }

    }

    private ModificadorState getExclusivoOrAnulador(int anulador, int exclusividad) {

        if(anulador != 0){
            return new ExclusividadDePuntaje();
        }else{
            return new ExclusividadDePuntaje();
        }
    } */

    public ModificadorState checkContraModificadorNulo(ModificadorState modificadorState, List<Jugador> jugadores) {
        int modificadorCount = (int) jugadores.stream().filter(
                m->(m.obtenerModificadorActual().equals(modificadorState))).count();
        return ( modificadorCount ==0 ? new ModificadorNulo() : modificadorState);
    }

    //
}
