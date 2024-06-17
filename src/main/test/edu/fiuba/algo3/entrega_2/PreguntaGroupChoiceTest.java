package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
public class PreguntaGroupChoiceTest {

    private static String enunciado;
    private static ArrayList<String> opciones;
    private static Respuesta respuestaCorrecta;
    private static Pregunta pregunta;

    @BeforeAll
    static void setUpPregunta() {
        enunciado = "Paises ganaron algun mundial y los que no";
        opciones = new ArrayList<String>(Arrays.asList("Argentina", "Italia", "Chile", "Nigeria", "Uruguay"));
        respuestaCorrecta = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(1, 2, 5)), new ArrayList<Integer>(Arrays.asList(3, 4)));
        pregunta = new PreguntaGroupChoice(enunciado, opciones, respuestaCorrecta);
    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaGroupChoiceYNoRecibePuntos() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), new ArrayList<Integer>(Arrays.asList(4, 5)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(3, 4)), new ArrayList<Integer>(Arrays.asList(5, 2, 1)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceDeOtraFormaYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<Integer>(Arrays.asList(2, 5, 1)), new ArrayList<Integer>(Arrays.asList(4, 3)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }
}
*/