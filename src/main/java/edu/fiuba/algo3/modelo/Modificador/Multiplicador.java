package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public interface Multiplicador {

    void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion);

    int consultarValor();
}
