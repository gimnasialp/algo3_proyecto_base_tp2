package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class AlgoHoot {

    private  Limite limite;
    private  List<Jugador> jugadores;
    private List<Partida> partidas;
    private Jugador jugadorActual;
    private Pregunta preguntaActual;
    private Partida partidaActual;
    private int numeroPartida;


    public AlgoHoot(List<Jugador> jugadores, List<Pregunta> preguntas, Limite limite){
        this.jugadores = jugadores;
        this.limite = limite;
        this.partidas = new ArrayList<>();
        iniciarPartidas();
    }

    private void iniciarPartidas() {
        jugadorActual = jugadores.stream().findFirst().get();
        preguntaActual = limite.preguntaNoLimitada(jugadores);
        Partida partida = new Partida(preguntaActual, this.jugadores, jugadorActual);
        numeroPartida = 0;
        partidas.add(partida);
    }

    public void proximaPartida(){
        comprobarPartidaExistente();
       // partidaActual = partidas.get(numeroPartida);
        //tal vez habra Observers
    }

    private void comprobarPartidaExistente() {
        if(numeroPartida+1 > partidas.size() ){
            preguntaActual = limite.preguntaNoLimitada(jugadores);
            Partida partida = new Partida(preguntaActual, this.jugadores, jugadorActual);
            partidas.add(partida);
        }
        partidaActual = partidas.get(numeroPartida);
        numeroPartida++;
    }

    public Partida obtenerPartidaActiva(){
        return partidaActual;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }

}
