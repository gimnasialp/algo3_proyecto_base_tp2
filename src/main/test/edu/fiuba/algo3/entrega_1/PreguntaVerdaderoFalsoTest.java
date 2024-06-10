package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoTest {

    @Test
    public void UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespeustaYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico("Argentina es el actual campeon mundial de futbol", new ArrayList<String>(Arrays.asList("Verdadero", "Falso")), new RespuestaVerdaderoFalso("Verdadero"));
        ArrayList<Respuesta> respuestaDeJugadores = ArrayList<Respuesta>(Arrays.asList(new RespuestaVerdaderoFalso("Verdadero"), RespuestaVerdaderoFalso("Falso")));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }
}
