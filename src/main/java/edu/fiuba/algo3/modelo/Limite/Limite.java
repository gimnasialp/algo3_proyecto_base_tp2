package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.LinkedList;
import java.util.List;

/*
public abstract class Limite {

    private int puntos;

    public  Limite(int puntos){
        this.puntos = puntos;
    }

    protected Limite() {
    }

    public int obtenerPuntosLimite() {
        return puntos;
    }

    public abstract List<Pregunta> limitar(List<Pregunta> preguntas);


}
*/

public abstract class Limite {

    protected ObtenedorPreguntaSiguiente obtenedorPregunta;
    protected List<Pregunta> preguntas;

    public Limite(List<Pregunta> preguntas){
        this.preguntas = preguntas;
        this.obtenedorPregunta = new ObtenedorPreguntaSiguienteSegunTema(this.preguntas);
    }

    public Limite() {
    }

    public abstract Pregunta preguntaNoLimitada(List<Jugador> jugador);

    public Pregunta obtenerPreguntaSgte() {
        return this.obtenedorPregunta.obtenerPreguntaSiguiente();
        /*if (preguntas.size() > 0) {
            Pregunta pregunta = preguntas.get(0);
            preguntas.remove(0);
            return pregunta;
        }else{
            throw new SinPreguntasDisponiblesException();
        }*/
    }

    /*public int preguntasRestantesLimite(){
        return preguntas.size();
    }*/

}