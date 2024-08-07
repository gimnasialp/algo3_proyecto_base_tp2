package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Limite.LimitadorPorNumeroPreguntas;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.PuntosDefinidosDecorator;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class AlgoHoot {

    private Limite limite;
    private List<Jugador> jugadores;
    private List<Partida> partidas;
    private Jugador jugadorActual;
    private Pregunta preguntaActual;
    private Partida partidaActual;
    private int numeroPartida;

    //atributos nuevos de prueba
    private boolean limitadorPorCantidadPreguntas;


    public AlgoHoot(List<Jugador> jugadores, Limite limite) {
        this.jugadores = jugadores;
        this.limite = limite;
        this.partidas = new ArrayList<>();
        iniciarPartidas();
    }

    private void iniciarPartidas() {
        jugadorActual = jugadores.stream().findFirst().get();
        preguntaActual = limite.preguntaNoLimitada(jugadores);
        Partida partida = new Partida(preguntaActual, this.jugadores);
        numeroPartida = 0;
        partidas.add(partida);

    }

    public void proximaPartida() {
        comprobarPartidaExistente();
    }

    private void comprobarPartidaExistente() {
        if (numeroPartida + 1 > partidas.size()) {
            preguntaActual = limite.preguntaNoLimitada(jugadores);
            Partida partida = new Partida(preguntaActual, this.jugadores);
            partidas.add(partida);
        }
        partidaActual = partidas.get(numeroPartida);
        numeroPartida++;
        partidaActual.resetearComodines(jugadores);

    }

    public Partida obtenerPartidaActiva() {
        return partidaActual;
    }

    public List<Jugador> consultarJugadores() {
        return jugadores;
    }

    public int consultarCantidadDePartidasActuales() {
        return partidas.size();
    }


    public int obtenerCantidadPreguntasRestantes() {
        return this.limite.preguntasRestantesLimite();
    }

}
