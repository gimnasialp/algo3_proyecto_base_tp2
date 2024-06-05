package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {
    private Respuesta respuestaCorrectaMCUno;
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
    public void creoUnaPreguntaDeMCClasico() {
        setupRespuestasMC();
        ArrayList<Respuesta> respuestas = new ArrayList<>(Arrays.asList(this.respuestaCorrectaMCUno, this.respuestaCorrectaMCDos, this.respuestaCorrectaMCTres, this.respuestaIncorrectaMCUno));
        this.unaPreguntaDeMCClasico = new MultipleChoiceClasico("Java tiene versiones de numero...", respuestas);
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
    

}
