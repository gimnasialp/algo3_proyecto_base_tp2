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
    private ArrayList<Pregunta> preguntas;

    @BeforeEach
    public void setUpPreguntas() {
        this.jugadorUno = new Jugador("Casimiro");
        this.jugadorDos = new Jugador("Mafalda");
        LectorPreguntasJson lector = new LectorPreguntasJson();
        this.preguntas = lector.generarPreguntas();
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaVerdaderoFalsoClasicoAmbosActivanElAnuladorYTodosLosJugadoresRecibenCeroPuntos() {

        Pregunta preguntaVerdaderoFalsoClasico = preguntas.stream().filter(p -> p.mismoId(3)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(2);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        Resultado resultado = preguntaVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new AnuladorDePuntaje(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondeIncorrectamenteUnaPreguntaVerdaderoFalsoConPenalidadAmbosActivanMultiplicadorYAmbosRecibenSusPuntos() {

        Pregunta preguntaVerdaderoFalsoConPenalidad = preguntas.stream().filter(p -> p.mismoId(10)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(2);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        Resultado resultado = preguntaVerdaderoFalsoConPenalidad.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new MultiplicarPorDos(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(-1 * 3, jugadorUno.obtenerPuntaje());
        assertEquals(-1 * 2, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void deDosJugadoresUnoRespondeCorrectamenteUnaPreguntaMultipleChoiceClasicoYActivaUnMultiplicadorElOtroActivaElAnuladorNadieRecibePuntos() {

        Pregunta preguntaMultipleChoiceClasico = preguntas.stream().filter(p -> p.mismoId(9)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceClasico(new ArrayList<>(Arrays.asList(3)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceClasico(new ArrayList<>(Arrays.asList(5)));

        Resultado resultado = preguntaMultipleChoiceClasico.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void deDosJugadoresUnoRespondeCorrectamenteUnaPreguntaMultipleChoiceParcialAmbosActivanLaExclusividadYSoloUnoRecibeElDobleDeSusPuntos() {

        Pregunta preguntaMultipleChoicePuntajeParcial = preguntas.stream().filter(p -> p.mismoId(8)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(4, 1)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceParcial(new ArrayList<>(Arrays.asList(3, 5)));

        Resultado resultado = preguntaMultipleChoicePuntajeParcial.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(2 * 2 * 2, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaMultipleChoiceConPenalidadAmbosActivanMultiplicadorYRecibenSusPuntos() {

        Pregunta preguntaMultipleChoiceConPenalidad = preguntas.stream().filter(p -> p.mismoId(14)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(3)));
        Respuesta respuestaJugadorDos = new RespuestaMultipleChoiceConPenalidad(new ArrayList<>(Arrays.asList(3)));

        Resultado resultado = preguntaMultipleChoiceConPenalidad.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new MultiplicarPorDos(), 0);
        resultado.usarModificador(new MultiplicarPorTres(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(1 * 2, jugadorUno.obtenerPuntaje());
        assertEquals(1 * 3, jugadorDos.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaOrderedChoiceAmbosActivanExclusividadQueNoAfectaANingunoYRecibenSusPuntos() {

        Pregunta preguntaOrderedChoice = preguntas.stream().filter(p -> p.mismoId(17)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));
        Respuesta respuestaJugadorDos = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));

        Resultado resultado = preguntaOrderedChoice.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(1, jugadorUno.obtenerPuntaje());
        assertEquals(1, jugadorDos.obtenerPuntaje());
    }


    @Test
    public void dosJugadoresRespondenCorrectamenteUnaPreguntaGroupChoiceElPrimeroActivaExclusividadElOtroActivaElAnuladorYSoloUnoRecibePuntos() {

        Pregunta preguntaGroupChoice = preguntas.stream().filter(p -> p.mismoId(18)).findFirst().get();

        Respuesta respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(6, 3, 4)));
        Respuesta respuestaJugadorDos = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(4, 6, 3)), new ArrayList<>(Arrays.asList(2, 1, 5)));

        Resultado resultado = preguntaGroupChoice.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(1, jugadorDos.obtenerPuntaje());
    }

}
