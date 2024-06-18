package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    private Pregunta preguntaGroupChoice;

    @BeforeEach
    public void setUpPregunta() {
        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        this.preguntaGroupChoice = preguntas.stream().filter(p -> p.mismoId(18)).findFirst().get();
    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaGroupChoiceYNoRecibePuntos() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(4, 5, 6)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(3, 4, 6)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceDeOtraFormaYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(3, 4, 6)), new ArrayList<>(Arrays.asList(1, 2, 5)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }
}