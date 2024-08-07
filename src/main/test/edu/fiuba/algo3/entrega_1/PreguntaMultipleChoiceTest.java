package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    private String enunciado;
    private ArrayList<String> opciones;
    private Respuesta respuestaCorrecta;
    private int idPregunta;
    private String tema;
    private String textoRepuesta;

    @BeforeEach
    public void setUpPregunta() {
        this.enunciado = "Que paises ganaron mundiales";
        this.opciones = new ArrayList<>(Arrays.asList("Argentina", "Nigeria", "Suiza", "Francia", "Alemania", "Chile"));
        this.idPregunta = 182;
        this.tema = "DEPORTES";
        this.textoRepuesta = "Argentina, Alemania y Francia fueron campeones mundiales de futbol";
    }

    @Test
    public void unaPreguntaMultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlResultadoDeLaRonda() {

        this.respuestaCorrecta = new RespuestaMultipleChoiceClasico(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceClasico(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceClasico(new ArrayList<>(Arrays.asList(5, 1, 4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceClasico(new ArrayList<>(Arrays.asList(1, 5)));

        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void unaPreguntaDeMultipleChoiceConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlResultadoDeLaRonda() {

        this.respuestaCorrecta = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceConPenalidad(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(5, 1, 4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(1, 5)));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(4, 6)));

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
    public void unaPreguntaDeMultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosAlResultadoDeLaRonda() {

        this.respuestaCorrecta = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(1, 4, 5)));
        Pregunta pregunta = new PreguntaMultipleChoiceParcial(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(5, 1, 4)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceParcial(new ArrayList<>(List.of(1)));
        Respuesta respuestaJugadorTres = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(1, 6, 5)));
        Respuesta respuestaJugadorCuatro = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(6, 1, 5, 4)));

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
    }
}
