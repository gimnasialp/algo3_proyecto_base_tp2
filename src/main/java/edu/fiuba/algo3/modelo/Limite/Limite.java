package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;


public abstract class Limite {

    protected List<Pregunta> preguntas;

    public Limite(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Limite() {
    }

    public abstract Pregunta preguntaNoLimitada(List<Jugador> jugador);

    public Pregunta obtenerPreguntaSgte() {
        if (preguntas.size() > 0) {
            Pregunta pregunta = preguntas.get(0);
            preguntas.remove(0);
            return pregunta;
        } else {
            throw new SinPreguntasDisponiblesException();
        }
    }

    public abstract int preguntasRestantesLimite();
}