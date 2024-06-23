package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private  Jugador jugador;
    private  Pregunta pregunta;

    private  List<Respuesta> respuestas;
    private Jugador jugadorActivo;
    private List<Jugador> jugadores;

    public Partida(Pregunta preguntaActual, List<Jugador> jugadores, Jugador jugadorActual) {
        this.pregunta = preguntaActual;
        //this.puntuador = new PuntuadorComun();
        this.respuestas = new ArrayList<>();
        this.jugador = jugadorActual;
    }


    public void avanzoConSiguienteJugador() {
        jugadorActivo = nuevoJugador();
        //posible observer
        
    }

    private Jugador nuevoJugador(){
        if(!jugadores.isEmpty()){
            Jugador jugador = jugadores.get(0);
            jugadores.remove(0);
            return jugador;
        }
        return jugadorActivo;
    }

    public Jugador obtenerJugadorActivo() {
        return  jugadorActivo;
    }


    public void agregarRespuesta(Responder respondeJugador) {
        respuestas.add((Respuesta) respondeJugador.getRespuestaDeJugador());
        if(!jugadores.isEmpty()){
            avanzoConSiguienteJugador();
        }else{
            procesarRespuestasDeLaPartida(respuestas);
        }
    }

    private void procesarRespuestasDeLaPartida(List<Respuesta> respuestas) {
       // int puntos = pregunta.evaluar((ArrayList<Respuesta>) this.respuestas);
        //posiblesObservadores
    }
}
