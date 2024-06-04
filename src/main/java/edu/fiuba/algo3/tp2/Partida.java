package edu.fiuba.algo3.tp2;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partida {

    private List<Jugador> jugadores;
    private Pregunta pregunta;
    public Partida(Pregunta pregunta, ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.pregunta = pregunta;
    }



    private void asignarPuntos(ArrayList<Integer> puntos){
        int posicion=0;
        for (Jugador jugadorIterator : this.jugadores) {
            jugadorIterator.agregarPuntuacion(puntos.get(posicion));
            posicion++;
        }
    }

    public void procesarRespuestas(ArrayList<Respuesta> respuestas){
        ArrayList<ArrayList<Respuesta>> listRespuestas = new ArrayList<>(Arrays.asList(respuestas));
        ArrayList<Integer> puntos = this.pregunta.responder(listRespuestas);
        this.asignarPuntos(puntos);
    }

}
