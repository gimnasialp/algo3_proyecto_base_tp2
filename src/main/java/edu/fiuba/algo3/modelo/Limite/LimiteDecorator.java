package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;

public class LimiteDecorator extends Limite {
    protected Limite decoratedLimite;

    public LimiteDecorator(Limite decoratorLimite, List<Pregunta> preguntas) {
        super(preguntas);
        this.decoratedLimite = decoratorLimite;
    }
    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        return decoratedLimite.preguntaNoLimitada(jugadores);
    }

    @Override
    public int preguntasRestantesLimite() {
        return decoratedLimite.preguntasRestantesLimite();
    };
}
