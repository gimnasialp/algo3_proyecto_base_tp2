package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public interface ModificadorState {

    void aplicarState(ModificadorContextState modificadorContextState,
                      ArrayList<Integer> puntajeRonda, int jugadorPosicion);
}
