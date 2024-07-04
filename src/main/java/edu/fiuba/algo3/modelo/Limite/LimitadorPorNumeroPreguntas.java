package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;


public class LimitadorPorNumeroPreguntas extends Limite {

    public LimitadorPorNumeroPreguntas(int limitePreguntas, List<Pregunta> preguntasParaLimitar) {
        super(preguntasParaLimitar.subList(0, limitePreguntas));
    }

    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        return super.obtenerPreguntaSgte();
    }


}