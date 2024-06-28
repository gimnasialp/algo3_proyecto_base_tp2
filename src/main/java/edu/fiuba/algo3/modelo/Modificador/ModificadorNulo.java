package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class ModificadorNulo implements Modificador,ModificadorState {

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {

    }

    @Override
    public void aplicarState(ModificadorContextState modificadorContextState, ArrayList<Integer> puntajeRonda, int jugadorPosicion) {

    }
}
