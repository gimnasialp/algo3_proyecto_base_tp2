package edu.fiuba.algo3.modelo.Limite;

import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
public class LimitadorPorNumeroPreguntas extends Limite {

    private int inicioPosicionDeListaPreguntas = 0;

    private int cantidadPreguntas;
    public LimitadorPorNumeroPreguntas(int cantidadPreguntas) {
        //el limite por default es cero, no importara en el juego ya que se regirá por nro preguntas.
        super(0);
        this.cantidadPreguntas = cantidadPreguntas;
    }

    @Override
    public List<Pregunta> limitar(List<Pregunta> preguntas) {
        List<Pregunta> preguntasLimitadas = preguntas.subList(inicioPosicionDeListaPreguntas, cantidadPreguntas);
        return preguntas;
    }

    public int obtenerLimitePreguntas() {
        return cantidadPreguntas;
    }
}
*/

public class LimitadorPorNumeroPreguntas extends Limite{

    private int limitePreguntas;
    public LimitadorPorNumeroPreguntas(int limitePreguntas,List<Pregunta> preguntasParaLimitar){
        super(preguntasParaLimitar.subList(0, limitePreguntas));
    }
    @Override
    public Pregunta preguntaNoLimitada(List<Jugador> jugadores) {
        return super.obtenerPreguntaSgte();
    }
}