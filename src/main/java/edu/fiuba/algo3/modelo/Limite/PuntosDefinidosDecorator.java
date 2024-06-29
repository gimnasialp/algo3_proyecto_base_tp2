package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.Comparator;
import java.util.List;

public class PuntosDefinidosDecorator extends LimiteDecorator{

    protected Limite decoratedLimite;

    private int  puntajeLimite;
    public PuntosDefinidosDecorator(Limite decoratedLimite, List<Pregunta> preguntas, int puntajeLimite) {
        super(decoratedLimite,preguntas);
        this.puntajeLimite = puntajeLimite;
    }


    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        Pregunta pregunta = super.decoratedLimite.preguntaNoLimitada(jugadores);
        if(!superaPuntajeLimite( jugadores)){
            return pregunta;
        }else{
            throw new PuntajeMaximoSuperadoException();
        }
    }

    private boolean superaPuntajeLimite(List<Jugador> jugadores){
        int puntajeMayorActualJuego =
                jugadores.stream().max(Comparator.comparing(Jugador::obtenerPuntaje)).get().obtenerPuntaje();
        return (puntajeMayorActualJuego > puntajeLimite);
    }
}