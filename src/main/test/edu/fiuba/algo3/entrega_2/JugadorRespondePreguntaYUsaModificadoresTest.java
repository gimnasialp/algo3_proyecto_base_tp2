package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorRespondePreguntaYUsaModificadoresTest {

    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private ArrayList<Pregunta> preguntas;

    @BeforeEach
    public void setUpPreguntas() {
        this.jugadorUno = new Jugador("Casimiro");
        this.jugadorDos = new Jugador("Mafalda");
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        this.preguntas = proveedor.obtenerPreguntasDe("preguntas.json");
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

}
