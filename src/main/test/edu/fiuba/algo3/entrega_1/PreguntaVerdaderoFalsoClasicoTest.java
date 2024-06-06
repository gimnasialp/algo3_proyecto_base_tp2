package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Preguntas.VoF.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoClasicoTest {

    private VerdaderoFalsoClasico unaPreguntaDeVFClasico;
    private Respuesta respuestaCorrectaVF;
    private Respuesta respuestaIncorrectaVF;

    public void setRespuestasVF() {
        this.respuestaCorrectaVF = new RespuestaCorrecta("Verdadero");
        this.respuestaIncorrectaVF = new RespuestaIncorrecta("Falso");
    }
    public void creoUnaPreguntaDeVFClasico() {
        setRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFClasico = new VerdaderoFalsoClasico("Argentina es el actual Campeon Mundial", respuestas);
    }
    @Test
    public void unaPreguntaDeVFClasicoRecibeRespuestas_entoncesAsignaPuntosCorrectosEIncorrectos() { //Pto. 1 & 2
        creoUnaPreguntaDeVFClasico();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFClasico.responder(respuestas);
        int puntoObtenidoJugadorUno = 1;
        int puntoObtenidoJugadorDos = 0;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));
    }
    @Test
    public void unaPreguntaDeVFClasicoRecibeRespuestasYAsignaPuntosIncorrectos() { //Pto. 1 & 2

        creoUnaPreguntaDeVFClasico();
        ArrayList<Respuesta> respuestaJugadorUno = new ArrayList<>(Collections.singletonList(this.respuestaCorrectaVF));
        ArrayList<Respuesta> respuestaJugadorDos = new ArrayList<>(Collections.singletonList(this.respuestaIncorrectaVF));
        ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        ArrayList<Integer> puntosObtenidos = this.unaPreguntaDeVFClasico.responder(respuestas);
        int puntoObtenidoJugadorUno = 1;
        int puntoObtenidoJugadorDos =0;
        assertEquals(puntoObtenidoJugadorUno, puntosObtenidos.get(0));
        assertEquals(puntoObtenidoJugadorDos, puntosObtenidos.get(1));


    }


}
