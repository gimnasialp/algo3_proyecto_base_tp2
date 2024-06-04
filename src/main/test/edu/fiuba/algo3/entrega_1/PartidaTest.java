package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.tp2.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {

    @Test
    public void Test01RondaProcesaCorrectamenteLasRespuestasVF() {

        Jugador jugadorUno = new Jugador("pedro");
        Jugador jugadorDos = new Jugador("miguel");

        Respuesta correcta = new RespuestaCorrecta("Verdadero");
        Respuesta incorrecta = new RespuestaIncorrecta("Falso");
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(correcta, incorrecta));
        Pregunta pregunta = new VerdaderoFalsoClasico("Argentina es el actual campeon Mundial", respuestas);

        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(correcta));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(incorrecta));
        ArrayList<Respuesta> respuestasJugadores = new ArrayList<>(Arrays.asList(correcta,incorrecta));

        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(jugadorUno,jugadorDos));
        Partida partida = new Partida(pregunta, jugadores);

        partida.procesarRespuestas(respuestasJugadores);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(0, jugadorDos.puntaje());
    }
}
