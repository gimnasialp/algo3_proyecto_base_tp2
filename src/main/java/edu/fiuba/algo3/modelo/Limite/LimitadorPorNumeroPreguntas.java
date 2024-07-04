package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;


public class LimitadorPorNumeroPreguntas extends Limite {
    private int limiteTotal;
    public LimitadorPorNumeroPreguntas(int limitePreguntas, List<Pregunta> preguntasParaLimitar) {
        super(preguntasParaLimitar.subList(0, limitePreguntas));
        this.limiteTotal = limitePreguntas;
    }

    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        return super.obtenerPreguntaSgte();
    }



}