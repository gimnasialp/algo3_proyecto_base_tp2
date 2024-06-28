package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;

public class LimiteFinalPreguntas extends Limite{

    public LimiteFinalPreguntas( List<Pregunta> preguntasParaLimitar){
        super(preguntasParaLimitar);
    }
    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        return obtenerPreguntaSgte();
    }
}
