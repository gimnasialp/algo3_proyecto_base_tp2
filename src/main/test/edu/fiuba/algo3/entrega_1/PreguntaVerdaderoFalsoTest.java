package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.Arrays;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoTest {
    /*
    @Test
    public void UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));

        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void UnaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {

        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        Pregunta pregunta = new PreguntaVerdaderoFalsoConPenalidad(enunciado, opciones, respuestaCorrecta);

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos));

        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = -1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }*/

}
