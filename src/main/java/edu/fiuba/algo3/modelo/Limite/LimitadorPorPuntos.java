package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;

public class LimitadorPorPuntos extends Limite {

    private int posicionActualLista;

    public LimitadorPorPuntos(List<Pregunta> preguntas) {
        super(preguntas);
        this.posicionActualLista = 0;
    }

    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {

        Pregunta pregunta = super.preguntas.get(posicionActualLista);
        if (posicionActualLista == ((super.preguntas.size()) - 1)) {
            posicionActualLista = 0;
        }
        posicionActualLista++;
        return pregunta;
    }


    public int indicarLimiteAlcanzado() {
        return 0;
    }
}
