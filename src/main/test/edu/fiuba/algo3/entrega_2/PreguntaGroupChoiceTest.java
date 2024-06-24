package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    private Pregunta preguntaGroupChoice;

    @BeforeEach
    public void setUpPregunta() {
        HashMap<String, ParserRespuesta> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");
        this.preguntaGroupChoice = preguntas.stream().filter(p -> p.mismoId(18)).findFirst().get();
    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaGroupChoiceYNoRecibePuntos() {

        HashMap<String, ArrayList<Integer>> gruposJugadorUno = new HashMap<>();
        gruposJugadorUno.put("Deportes Grupales", new ArrayList<>(Arrays.asList(1, 2, 3)));
        gruposJugadorUno.put("Deportes Individuales", new ArrayList<>(Arrays.asList(4, 5, 6)));
        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(gruposJugadorUno);

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 0;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceYRecibeUnPunto() {

        HashMap<String, ArrayList<Integer>> gruposJugadorUno = new HashMap<>();
        gruposJugadorUno.put("Deportes Grupales", new ArrayList<>(Arrays.asList(1, 2, 5)));
        gruposJugadorUno.put("Deportes Individuales", new ArrayList<>(Arrays.asList(6, 3, 4)));
        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(gruposJugadorUno);

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }

    @Test
    public void unJugadorRespondeCorrectamenteUnaPreguntaGroupChoiceDeOtraFormaYRecibeUnPunto() {

        HashMap<String, ArrayList<Integer>> gruposJugadorUno = new HashMap<>();
        gruposJugadorUno.put("Deportes Individuales", new ArrayList<>(Arrays.asList(3, 4, 6)));
        gruposJugadorUno.put("Deportes Grupales", new ArrayList<>(Arrays.asList(1, 2, 5)));
        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(gruposJugadorUno);

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno));
        Resultado resultado = preguntaGroupChoice.responder(respuestaDeLosJugadores);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));
    }
}