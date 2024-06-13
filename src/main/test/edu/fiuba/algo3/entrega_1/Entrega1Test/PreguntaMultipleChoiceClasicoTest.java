package edu.fiuba.algo3.entrega_1.Entrega1Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {
   /* private Respuesta respuestaCorrectaMCUno;
    private Respuesta respuestaCorrectaMCDos;
    private Respuesta respuestaCorrectaMCTres;
    private Respuesta respuestaIncorrectaMCUno;
    private MultipleChoiceClasico unaPreguntaDeMCClasico;

    public void setupRespuestasMC() {
        this.respuestaCorrectaMCUno = new RespuestaCorrecta("8");
        this.respuestaCorrectaMCDos = new RespuestaCorrecta("11");
        this.respuestaCorrectaMCTres = new RespuestaCorrecta("17");
        this.respuestaIncorrectaMCUno = new RespuestaIncorrecta("fruta");
    }
    @BeforeEach
    public void creoUnaPreguntaDeMCClasico() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCClasico = new MultipleChoiceClasico("Java tiene versiones de numero...", respuestas);
    }
    @Test
    public void unaPreguntaDeMCClasicoRecibeRespuestasYAsignaPuntosCorrectos() { //Pto. 3
        int puntoObtenidoJugadorUno = 1;
        int puntoObtenidoJugadorDos = 1;

        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCClasico.responder(respuestasUsuarios);

        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }
    @Test
    public void unaPreguntaDeMCClasicoRecibeRespuestasYasignaPuntosAjugadorQueRespondieronIncorrectamente() { //Pto.4

        int puntoObtenidoJugadorUno = 1;
        int puntoObtenidoJugadorDos = 0;
        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCClasico.responder(respuestasUsuarios);

        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }*/
    

}
