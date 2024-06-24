package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.Arrays;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoConPenalidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoTest {

    private String enunciado;
    private ArrayList<String> opciones;
    private Respuesta respuestaCorrecta;
    private int idPregunta;
    private String tema;
    private String tipo;
    private String textoRespuesta;

    @BeforeEach
    public void setUpPregunta() {
        this.enunciado = "Argentina es el actual campeon mundial de futbol";
        this.opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        this.idPregunta = 16;
        this.tema = "DEPORTES";
        this.textoRespuesta = "Argentina gano mundial de futbol en 2022";
    }

    @Test
    public void unaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlResultadoDeLaRonda() {
        this.tipo = "verdadero falso simple";
        this.respuestaCorrecta = new RespuestaVerdaderoFalsoClasico(1);
        Pregunta pregunta = new Pregunta(idPregunta, tema, tipo, enunciado, opciones, textoRespuesta, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalsoClasico(1);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalsoClasico(2);
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));

        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void unaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlResultadoDeLaRonda() {
        this.tipo = "verdadero falso penalidad";
        this.respuestaCorrecta = new RespuestaVerdaderoFalsoConPenalidad(1);
        Pregunta pregunta = new Pregunta(idPregunta, tema, tipo, enunciado, opciones, textoRespuesta, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalsoConPenalidad(1);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalsoConPenalidad(2);
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));

        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = -1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

}
