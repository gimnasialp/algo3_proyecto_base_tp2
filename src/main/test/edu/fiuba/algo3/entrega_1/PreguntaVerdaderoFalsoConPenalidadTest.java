package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.VoF.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {

    private Respuesta respuestaCorrectaVF;
    private Respuesta respuestaIncorrectaVF;

    private VerdaderoFalsoConPenalidad unaPreguntaDeVFConPenalidad;

    public void setRespuestasVF() {
        this.respuestaCorrectaVF = new RespuestaCorrecta("Verdadero");
        this.respuestaIncorrectaVF = new RespuestaIncorrecta("Falso");
    }

    public void creoUnaPreguntaDeVFConPenalidad() {
        setRespuestasVF();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaVF, this.respuestaIncorrectaVF));
        this.unaPreguntaDeVFConPenalidad = new VerdaderoFalsoConPenalidad("Argentina es el actual Campeon Mundial", respuestas);
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

}
