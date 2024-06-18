package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.*;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorRespondePreguntaYUsaModificadoresTest {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Pregunta preguntaVerdaderoFalsoClasico;
    private Pregunta preguntaVerdaderoFalsoConPenalidad;
    private Pregunta preguntaMultipleChoiceClasico;
    private Pregunta preguntaMultipleChoicePuntajeParcial;
    private Pregunta preguntaMultipleChoiceConPenalidad;
    private Pregunta preguntaOrderedChoice;
    private Pregunta preguntaGroupChoice;

    @BeforeEach
    public void setUpPreguntas() {
        this.jugadorUno = new Jugador("Casimiro");
        this.jugadorDos = new Jugador("Mafalda");

        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();

        this.preguntaVerdaderoFalsoClasico = preguntas.stream().filter(p -> p.mismoId(3)).findFirst().get();
        this.preguntaVerdaderoFalsoConPenalidad = preguntas.stream().filter(p -> p.mismoId(10)).findFirst().get();
        this.preguntaMultipleChoiceClasico = preguntas.stream().filter(p -> p.mismoId(9)).findFirst().get();
        this.preguntaMultipleChoicePuntajeParcial = preguntas.stream().filter(p -> p.mismoId(8)).findFirst().get();
        this.preguntaMultipleChoiceConPenalidad = preguntas.stream().filter(p -> p.mismoId(14)).findFirst().get();
        this.preguntaOrderedChoice = preguntas.stream().filter(p -> p.mismoId(17)).findFirst().get();
        this.preguntaGroupChoice = preguntas.stream().filter(p -> p.mismoId(18)).findFirst().get();
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaVerdaderoFalsoClasicoAmbosActivanElAnuladorYTodosLosJugadoresRecibenCeroPuntos() {

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(2);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        Resultado resultado = preguntaVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new AnuladorDePuntaje(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondeIncorrectamenteUnaPreguntaVerdaderoFalsoConPenalidadAmbosActivanMultiplicadorYAmbosRecibenSusPuntos() {

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(2);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        Resultado resultado = preguntaVerdaderoFalsoConPenalidad.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new MultiplicarPorDos(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(-1 * 3, jugadorUno.obtenerPuntaje());
        assertEquals(-1 * 2, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void deDosJugadoresUnoRespondeCorrectamenteUnaPreguntaMultipleChoiceClasicoYActivaUnMultiplicadorElOtroActivaElAnuladorNadieRecibePuntos() {

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceComun(new ArrayList<>(Arrays.asList(3)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceComun(new ArrayList<>(Arrays.asList(5)));

        Resultado resultado = preguntaMultipleChoiceClasico.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void deDosJugadoresUnoRespondeCorrectamenteUnaPreguntaMultipleChoiceParcialAmbosActivanLaExclusividadYSoloUnoRecibeElDobleDeSusPuntos() {

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(4, 1)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(3, 5)));

        Resultado resultado = preguntaMultipleChoicePuntajeParcial.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(2 * 2 * 2, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaMultipleChoiceConPenalidadAmbosActivanMultiplicadorYRecibenSusPuntos() {

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(3)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceEspecial(new ArrayList<>(Arrays.asList(3)));

        Resultado resultado = preguntaMultipleChoiceConPenalidad.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorDos(), 0);
        resultado.usarModificador(new MultiplicarPorTres(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(1 * 2, jugadorUno.obtenerPuntaje());
        assertEquals(1 * 3, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaOrderedChoiceAmbosActivanExclusividadQueNoAfectaANingunoYRecibenSusPuntos() {

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));
        Respuesta respuestaJugadorDos = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));

        Resultado resultado = preguntaOrderedChoice.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(1, jugadorUno.obtenerPuntaje());
        assertEquals(1, jugadorDos.obtenerPuntaje());
    }


    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaGroupChoiceElPrimeroActivaExclusividadElOtroActivaElAnuladorYSoloUnoRecibePuntos() {

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(6, 3, 4)));
        Respuesta respuestaJugadorDos = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(4, 6, 3)), new ArrayList<>(Arrays.asList(2, 1, 5)));

        Resultado resultado = preguntaGroupChoice.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(1, jugadorDos.obtenerPuntaje());
    }
    // hacer tests con las demas preguntas con distintos modificadores y cantidad de jugadores
}
