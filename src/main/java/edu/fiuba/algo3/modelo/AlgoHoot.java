package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;

public class AlgoHoot {

    private  Limite limite;
    private  List<Jugador> jugadores;


    private List<Partida> partidas;

    private Jugador jugadorActual;
    private Pregunta preguntaActual;


    public AlgoHoot(List<Jugador> jugadores, List<Pregunta> preguntas, Limite limite){
        this.jugadores = jugadores;
        this.limite = limite;
       // this.preguntas = preguntas;
        //this.preguntas = new LinkedList<Pregunta>();
        //this.puntajeLimite = limite.preguntaNoLimitada(this.preguntas);
        this.jugadorActual = jugadores.stream().findFirst().get();
        iniciarPartidas(preguntas);
    }

    private void iniciarPartidas(List<Pregunta> preguntas) {
        this.jugadorActual = jugadores.stream().findFirst().get();
        //this.preguntaActual = limite.preguntaNoLimitada(preguntas);
        //Partida partida = new Partida(preguntaActual, this.jugadores);
       // partidas.add(partida);
    }


}
