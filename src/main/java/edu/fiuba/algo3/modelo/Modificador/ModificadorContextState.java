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
        actualModificadorState.aplicarState(this,puntajePartida,jugadorPosicio);
    }

    public Modificador modificadorGanador(List<Jugador> jugadorList){
        int anulador = (int) jugadorList.stream().filter(
                                        m->m.obtenerModificadorActual().equals(AnuladorDePuntaje.class)).count();
        int exclusividad = (int) jugadorList.stream().filter(
                m->(m.obtenerModificadorActual().equals(ExclusividadDePuntaje.class))).count();
        if(anulador == 0 & exclusividad==0){
            return new ModificadorNulo();
        }else{
            return getExclusivoOrAnulador(anulador, exclusividad);
        }

    }

    private Modificador getExclusivoOrAnulador(int anulador, int exclusividad) {
        if(anulador >= exclusividad){
            return new AnuladorDePuntaje();
        }else{
            return new ExclusividadDePuntaje();
        }
    }
}
