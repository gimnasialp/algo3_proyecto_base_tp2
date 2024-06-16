package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {/*

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaOrderedChoiceYRecibeUnPunto() {

        String enunciado = "Posicion correcta de los meses";
        ArrayList<String> opciones = new ArrayList<String>(Arrays.asList("Marzo", "Junio", "Abril", "Octubre", "Enero"));
        Respuesta respuestaCorrecta = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(5, 1, 3, 2, 4)));
        Pregunta pregunta = new PreguntaOrderedChoice(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(2, 4, 3, 1, 5)));
        Respuesta respuestaJugadorDos = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(5, 4, 3, 1, 2)));
        Respuesta respuestaJugadorTres = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(5, 1, 3, 2, 4)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 0;
        int puntosDelJugadorTres = 1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
    }*/
}
