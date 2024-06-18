package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaOrderedChoiceTest {

    private Pregunta preguntaOrderedChoice;

    @BeforeEach
    public void setUpPregunta(){
        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        this.preguntaOrderedChoice = preguntas.stream().filter(p -> p.mismoId(17)).findFirst().get();
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaOrderedChoiceYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 6, 5, 2)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaOrderedChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaOrderedChoiceYNoRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<Integer>(Arrays.asList(2, 4, 3, 1, 5, 6)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaOrderedChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

}
