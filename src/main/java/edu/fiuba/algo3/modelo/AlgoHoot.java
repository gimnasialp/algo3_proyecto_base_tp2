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
    private Partida partidaActual;


    public AlgoHoot(List<Jugador> jugadores, List<Pregunta> preguntas, Limite limite){
        this.jugadores = jugadores;
        this.limite = limite;
        iniciarPartidas(preguntas);
    }

    private void iniciarPartidas(List<Pregunta> preguntas) {
        jugadorActual = jugadores.stream().findFirst().get();
        preguntaActual = limite.preguntaNoLimitada(jugadores);
        Partida partida = new Partida(preguntaActual, this.jugadores, jugadorActual);
        partidas.add(partida);
    }

    public void proximaPartida(){
        partidaActual = partidas.get(0);
        //tal vez habra Observers
    }

    public Partida obtenerPartidaActiva(){
        return partidaActual;
    }



}
