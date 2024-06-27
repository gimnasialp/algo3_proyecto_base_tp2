package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partida {

    //posicion de lista de jugadores para recorrer secuencialmente
    private int direccionListaJugador;
    private  Pregunta pregunta;

    private  List<Respuesta> respuestas;
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
        //posible observer
        
    }

    private Jugador nuevoJugador(){
        if((direccionListaJugador +1) <= jugadores.size()){
            Jugador jugador = jugadores.get(direccionListaJugador);
            direccionListaJugador++;
            return jugador;
        }
        return jugadorActivo;
    }

    public Jugador obtenerJugadorActivo() {
        return  jugadorActivo;
    }


    public void agregarRespuesta(Respuesta respondeJugador) {
        respuestas.add(respondeJugador);
        if((direccionListaJugador +1) > jugadores.size()){
            evaluarRespuestasDePartidaActual();
            actualizarPartidaEnJugadores();
        }
    }

    private void actualizarPartidaEnJugadores() {
        List<Integer> resultadosPartidaActual = resultado.obtenerPuntosDeJugadores();
        for (int i = 0; i < resultadosPartidaActual.size(); i++) {
            jugadores.get(i).asignarPuntos(resultadosPartidaActual.get(i));
        }
    }

    private void evaluarRespuestasDePartidaActual() {
        resultado = pregunta.responder((ArrayList<Respuesta>) this.respuestas);
        analisisModificadores();
    }

    private void analisisModificadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            Modificador multiplicador = jugadores.get(i).obtenerModificadorActual();
            resultado.usarModificador(multiplicador,i);
            jugadores.get(i).resetearMultiplicador();
        }
    }

    public Jugador jugadorConMasPuntos(){
        Jugador jugadorActualConMasPuntos = jugadores.get(0);
        for(Jugador jugador : jugadores){
            if(jugador.tieneMasPuntosQue(jugadorActualConMasPuntos)){
                jugadorActualConMasPuntos = jugador;
            }
        }
        return jugadorActualConMasPuntos;
    }

    public void activaMultiplicador(Modificador multiplicador, Jugador jugadorDePartidaActiva) {
        jugadorDePartidaActiva.aplicarNuevoMultiplicador(multiplicador);
    }
}
