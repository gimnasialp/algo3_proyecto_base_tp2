package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceConPenalidadTest {
    private Respuesta respuestaCorrectaMCUno;
    private Respuesta respuestaCorrectaMCDos;
    private Respuesta respuestaCorrectaMCTres;
    private Respuesta respuestaIncorrectaMCUno;
    private MultipleChoiceConPenalidad unaPreguntaDeMCConPenalidad;

    public void setupRespuestasMC() {
        this.respuestaCorrectaMCUno = new RespuestaCorrecta("8");
        this.respuestaCorrectaMCDos = new RespuestaCorrecta("11");
        this.respuestaCorrectaMCTres = new RespuestaCorrecta("17");
        this.respuestaIncorrectaMCUno = new RespuestaIncorrecta("fruta");

    }
    @BeforeEach
    public void creoUnaPreguntaDeMCConPenalidad() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCConPenalidad = new MultipleChoiceConPenalidad("Java tiene versiones de numero...", respuestas);
    }
    @Test
    public void unaPreguntaDeMCConPenalidadRecibeRespuestasAsignaPuntosAQuienesRespondieronBien() {
        // Pto. 7

        ArrayList<Respuesta> respuestasJugadorUno = new ArrayList<>(Arrays.asList(
                new RespuestaCorrecta("11"),
                new RespuestaCorrecta("8"),
                new RespuestaCorrecta("17")));
        ArrayList<Respuesta> respuestasJugadorDos = new ArrayList<>(Arrays.asList(
                new RespuestaCorrecta("11"),
                new RespuestaCorrecta("8"),
                new RespuestaCorrecta("17")));

        ArrayList<ArrayList<Respuesta>> respuestasUsuarios = new ArrayList<>(
                Arrays.asList(respuestasJugadorUno, respuestasJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeMCConPenalidad.responder(respuestasUsuarios);
        int puntoObtenidoJugadorUno =  3;
        int puntoObtenidoJugadorDos =  3;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }
    @Test
    public void unaPreguntaDeMCConPenalidadRecibeRespuestasAQuienesRespondieronBienYMal() { //PTO.8
        // Pto 8
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
        int puntoObtenidoJugadorUno = 2;
        int puntoObtenidoJugadorDos =-1;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }

}
