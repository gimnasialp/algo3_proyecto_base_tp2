package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Lector.OrderedChoiceParser;
import edu.fiuba.algo3.modelo.Lector.Parser;
import edu.fiuba.algo3.modelo.Lector.ProveedorJsonPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaOrderedChoiceTest {

    private Pregunta preguntaOrderedChoice;

    @BeforeEach
    public void setUpPregunta() {
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");
        this.preguntaOrderedChoice = preguntas.stream().filter(p -> p.mismoId(17)).findFirst().get();
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaOrderedChoiceYRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaOrderedChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaOrderedChoiceYNoRecibeUnPunto() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(2, 4, 3, 1, 5, 6)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaOrderedChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

}
