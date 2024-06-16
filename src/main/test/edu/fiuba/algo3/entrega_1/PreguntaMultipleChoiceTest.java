package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceComun;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceEspecial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {
/*
    @Test
    public void UnaPreguntaDeMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Que paises ganaron mundiales";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        Respuesta respuestaCorrecta = new RespuestaMultipleChoiceComun(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceClasico(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceComun(new ArrayList<>(Arrays.asList(5, 1, 4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceComun(new ArrayList<>(Arrays.asList(1, 5)));

        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void UnaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Que paises ganaron mundiales";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        Respuesta respuestaCorrecta = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceConPenalidad(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(5, 1, 4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(1, 5)));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(4, 6)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 3;
        int puntosDelJugadorDos = 2;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
    }

    @Test
    public void UnaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Que paises ganaron mundiales";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        Respuesta respuestaCorrecta = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceParcial(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(5, 1 ,4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceEspecial(new ArrayList<>(List.of(1)));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(1, 6, 5)));
        Respuesta respuestaJugadorCuatro = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(6, 1, 5, 4)));

        ArrayList<Respuesta> respuestaDeLosJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos, respuestaJugadorTres, respuestaJugadorCuatro));
        Resultado resultado = pregunta.responder(respuestaDeLosJugadores);

        int puntosDelJugadorUno = 3;
        int puntosDelJugadorDos = 1;
        int puntosDelJugadorTres = 2;
        int puntosDelJugadorCuatro = 3;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatro, resultado.obtenerPuntosDelJugador(3));
    }*/
}
