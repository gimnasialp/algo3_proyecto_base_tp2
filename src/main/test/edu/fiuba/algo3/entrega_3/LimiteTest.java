package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Limite.LimitadorPorNumeroPreguntas;
import edu.fiuba.algo3.modelo.Limite.LimitadorPorPuntos;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LimiteTest {

    @Test
    public void test_LimitadorDeJuego(){
        int puntos = 20;
        Limite limite = new LimitadorPorPuntos(puntos);
        Partida partida = new Partida();
        partida.setearLimite(limite);

        assertEquals(puntos,partida.obtenerLimite().obtenerPuntos());
    }

    @Test
    public void test_LimitadorDeJuego_PorCantidadDePreguntas(){
        int cantidadPreguntas = 10;
        Limite limite = new LimitadorPorNumeroPreguntas(cantidadPreguntas);
        Partida partida = new Partida();
        partida.setearLimite(limite);

        assertEquals(cantidadPreguntas, ((LimitadorPorNumeroPreguntas) limite).obtenerLimitePreguntas());
    }

    @Test
    public void test_LimitadorDeJuego_PorTotalidadPreguntas(){

        int cantidadPreguntas = 2;
        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        int idPregunta = 16;
        String tema = "DEPORTES";
        String textoRepuesta = "Argentina gano mundial de futbol en 2022";
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta,pregunta));

        LectorPreguntasJson lectorPreguntasJson = mock(LectorPreguntasJson.class);
        when(lectorPreguntasJson.generarPreguntas()).thenReturn(preguntas);

        Limite limite = new LimitadorPorNumeroPreguntas(lectorPreguntasJson.generarPreguntas().size());
        Partida partida = new Partida();
        partida.setearLimite(limite);

        assertEquals(cantidadPreguntas, ((LimitadorPorNumeroPreguntas) limite).obtenerLimitePreguntas());
    }
}
