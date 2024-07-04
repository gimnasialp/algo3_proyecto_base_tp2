package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private int direccionListaJugador;
    private Pregunta pregunta;

    private List<Respuesta> respuestas;
    private Jugador jugadorActivo;
    private List<Jugador> jugadores = new ArrayList<>();

    private Resultado resultado;


    public Partida(Pregunta preguntaActual, List<Jugador> jugadores) {
        this.pregunta = preguntaActual;
        this.respuestas = new ArrayList<>();
        this.direccionListaJugador = 0;
        this.jugadores.addAll(jugadores);
    }


    public void avanzoConSiguienteJugador() {
        jugadorActivo = nuevoJugador();

    }

    private Jugador nuevoJugador() {
        if ((direccionListaJugador + 1) <= jugadores.size()) {
            Jugador jugador = jugadores.get(direccionListaJugador);
            direccionListaJugador++;
            return jugador;
        }
        return jugadorActivo;
    }

    public Jugador obtenerJugadorActivo() {
        return jugadorActivo;
    }


    public void agregarRespuesta(Respuesta respondeJugador) {
        respuestas.add(respondeJugador);
        if ((direccionListaJugador + 1) > jugadores.size()) {
            evaluarRespuestasDePartidaActual();
            actualizarPartidaEnJugadores();
        }
    }

    private void actualizarPartidaEnJugadores() {
        List<Integer> resultadosPartidaActual = resultado.obtenerPuntosDeJugadores();
        for (int i = 0; i < resultadosPartidaActual.size(); i++) {
            jugadores.get(i).asignarPuntos(resultadosPartidaActual.get(i));
        }
        resultado.limpiarOpcionesDeAnteriorRonda();
    }

    private void evaluarRespuestasDePartidaActual() {
        resultado = pregunta.responder((ArrayList<Respuesta>) this.respuestas);
        analisisModificadores();
    }

    private void analisisModificadores() {
        analisisMultiplicadores();
        analisisPuntos();

    }

    private void analisisPuntos() {
        comprobarExclusividad();
        comprobarAnulador();

    }

    private void comprobarExclusividad() {
        comprobacionComodines(new ExclusividadDePuntaje());
    }

    private void comprobarAnulador() {
        comprobacionComodines(new AnuladorDePuntaje());
    }

    private void comprobacionComodines(Modificador modificadorState) {
        resultado.usarModificador(modificadorState, jugadores);
    }

    private void analisisMultiplicadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            Multiplicador modificador = jugadores.get(i).obtenerMultiplicador();
            resultado.usarModificador(modificador, i);
            jugadores.get(i).deshabilitarMultiplicador(modificador);
        }
    }

    public Jugador jugadorConMasPuntos() {
        Jugador jugadorActualConMasPuntos = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.tieneMasPuntosQue(jugadorActualConMasPuntos)) {
                jugadorActualConMasPuntos = jugador;
            }
        }
        return jugadorActualConMasPuntos;
    }

    public void activaMultiplicador(Multiplicador multiplicador, Jugador jugadorDePartidaActiva) {
        jugadorDePartidaActiva.aplicarNuevoMultiplicador(multiplicador);
    }

    public void resetearComodines(List<Jugador> jugadores) {
        jugadores.stream().forEach(j -> j.resetearComodines());
    }

    public Pregunta obtenerPreguntaActual() {
        return pregunta;
    }

    public void activaModificador(Modificador modificador, Jugador jugadorDePartidaActiva) {
        jugadorDePartidaActiva.aplicarNuevoModificador(modificador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
