package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    @Test
    public void UnaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        Pregunta pregunta = new PreguntaMultipleChoiceClasico("Que paises ganaron mundiales", new ArrayList<String>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile")), new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Francia", "Argentina"))));
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<Respuesta>(Arrays.asList(new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Argentina", "Francia"))), new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Argentina")))));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void UnaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Que paises ganaron mundiales";
        ArrayList<String> opciones = new ArrayList<String>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        Respuesta respuestaCorrecta = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Francia", "Argentina")));
        Pregunta pregunta = new PreguntaMultipleChoiceConPenalidad(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Argentina", "Francia")));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Argentina")));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Argentina", "Alemania", "Chile")));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 3;
        int puntosDelJugadorDos = 2;
        int puntosDelJugadorTres = 1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
    }

    @Test
    public void UnaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Que paises ganaron mundiales";
        ArrayList<String> opciones = new ArrayList<String>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        Respuesta respuestaCorrecta = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Francia", "Argentina")));
        Pregunta pregunta = new PreguntaMultipleChoiceParcial(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Alemania", "Argentina", "Francia")));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Argentina")));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Argentina", "Alemania", "Chile")));
        Respuesta respuestaJugadorCuatro = new RespuestaMultipleChoice(new ArrayList<String>(Arrays.asList("Chile", "Argentina", "Alemania", "Francia")));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<Respuesta>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres, respuestaJugadorCuatro));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 3;
        int puntosDelJugadorDos = 1;
        int puntosDelJugadorTres = 2;
        int puntosDelJugadorCuatro = 3;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatro, resultado.obtenerPuntosDelJugador(3));

    }


}
