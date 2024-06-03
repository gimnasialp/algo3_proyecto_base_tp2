package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.tp2.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TP2 {

    private Respuesta respuestaCorrectaVF;
    private Respuesta respuestaIncorrectaVF;

    private VerdaderoFalsoClasico unaPreguntaDeVFClasico;

    private Respuesta respuestaCorrectaMCUno;
    private Respuesta respuestaCorrectaMCDos;
    private Respuesta respuestaCorrectaMCTres;
    private Respuesta respuestaIncorrectaMCUno;

    private MultipleChoiceClasico unaPreguntaDeMCClasico;

    private VerdaderoFalsoConPenalidad unaPreguntaDeVFConPenalidad;

    private MultipleChoiceConPenalidad unaPreguntaDeMCConPenalidad;

    public void setRespuestasVF() {
        this.respuestaCorrectaVF = new RespuestaCorrecta("Verdadero");
        this.respuestaIncorrectaVF = new RespuestaIncorrecta("Falso");
    }

    public void setupRespuestasMC() {
        this.respuestaCorrectaMCUno = new RespuestaCorrecta("8");
        this.respuestaCorrectaMCDos = new RespuestaCorrecta("11");
        this.respuestaCorrectaMCTres = new RespuestaCorrecta("17");
        this.respuestaIncorrectaMCUno = new RespuestaIncorrecta("fruta");
    }

    public void creoUnaPreguntaDeVFConPenalidad() {
        setRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFConPenalidad = new VerdaderoFalsoConPenalidad("Argentina es el actual Campeon Mundial", respuestas);
    }

    public void creoUnaPreguntaDeVFClasico() {
        setRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFClasico = new VerdaderoFalsoClasico("Argentina es el actual Campeon Mundial", respuestas);
    }

    public void creoUnaPreguntaDeMCClasico() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCClasico = new MultipleChoiceClasico("Java tiene versiones de numero...", respuestas);
    }

    public void creoUnaPreguntaDeMCConPenalidad() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCConPenalidad = new MultipleChoiceConPenalidad("Java tiene versiones de numero...", respuestas);
    }

    /*  Entrega 1*/
    @Test
    public void unaPreguntaDeVFClasicoRecibeRespuestas_entoncesAsignaPuntosCorrectosEIncorrectos() { //Pto. 1 & 2
        creoUnaPreguntaDeVFClasico();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFClasico.responder(respuestas);
        int puntoObtenidoJugadorUno =1;
        int puntoObtenidoJugadorDos =0;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }

    @Test
    public void unaPreguntaDeMCClasicoRecibeRespuestas_entoncesAsignaPuntosCorrectosEIncorrectos() { //Pto. 3 & 4
        creoUnaPreguntaDeMCClasico();
        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaCorrectaMCUno));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCDos, this.respuestaIncorrectaMCUno, this.respuestaCorrectaMCUno));
        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCClasico.responder(respuestasUsuarios);
        int puntoObtenidoJugadorUno =1;
        int puntoObtenidoJugadorDos =0;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRecibeRespuestas_entoncesAsignaPuntosCorrectosEIncorrectos() { //Pto. 5
        creoUnaPreguntaDeVFConPenalidad();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFConPenalidad.responder(respuestas);
        int puntoObtenidoJugadorUno =1;
        int puntoObtenidoJugadorDos =-1;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }

    @Test
    public void unaPreguntaDeMCConPenalidadRecibeRespuestas_entoncesAsignaPuntosCorrectosEIncorrectos() { // Pto 7
        creoUnaPreguntaDeMCConPenalidad();

        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(
                new RespuestaCorrecta("11"),
                new RespuestaCorrecta("8"),
                new RespuestaCorrecta("17"),
                new RespuestaIncorrecta("fruta")));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(
                new RespuestaIncorrecta("fruta")));

        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(
                Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCConPenalidad.responder(respuestasUsuarios);
        int puntoObtenidoJugadorUno =2;
        int puntoObtenidoJugadorDos =-1;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }
}
