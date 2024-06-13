package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {

    private static String enunciado;
    private static ArrayList<String> opciones;
    private static Respuesta respuestaCorrecta;
    private static Pregunta pregunta;

    @BeforeAll
    public static void setUpPregunta(){
        enunciado = "Posicion correcta de los meses";
        opciones = new ArrayList<String>(Arrays.asList("Marzo", "Junio", "Abril", "Octubre", "Enero"));
        respuestaCorrecta = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(5, 1, 3, 2, 4)));
        pregunta = new PreguntaOrderedChoice(enunciado, opciones, respuestaCorrecta);
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaOrderedChoiceYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(5, 1, 3, 2, 4)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaOrderedChoiceYNoRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(2, 4, 3, 1, 5)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

}
