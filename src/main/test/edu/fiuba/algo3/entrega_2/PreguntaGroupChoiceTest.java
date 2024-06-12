package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceYRecibeUnPunto() {

        String enunciado = "Paises ganaron algun mundial y los que no";
        ArrayList<String> opciones = new ArrayList<String>(Arrays.asList("Argentina", "Italia", "Chile", "Nigeria", "Uruguay"));
        Respuesta respuestaCorrecta = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(1, 2, 5)), new ArrayList<Integer>(Arrays.asList(3, 4)));
        Pregunta pregunta = new PreguntaGroupChoice(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), new ArrayList<Integer>(Arrays.asList(4, 5)));
        Respuesta respuestaJugadorDos = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(3, 4)), new ArrayList<Integer>(Arrays.asList(5, 2, 1)));
        Respuesta respuestaJugadorTres = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(2, 5, 1)), new ArrayList<Integer>(Arrays.asList(5, 4)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 1;
        int puntosDelJugadorTres = 1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
    }
}
