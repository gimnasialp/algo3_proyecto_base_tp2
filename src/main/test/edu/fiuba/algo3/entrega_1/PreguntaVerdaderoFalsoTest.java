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

    @Test
    public void UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico("Argentina es el actual campeon mundial de futbol", new ArrayList<String>(Arrays.asList("Verdadero", "Falso")), new RespuestaVerdaderoFalso("Verdadero"));
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<Respuesta>(Arrays.asList(new RespuestaVerdaderoFalso("Verdadero"), new RespuestaVerdaderoFalso("Falso")));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

    @Test
    public void UnaPreguntaDeVerdaderoFalsoConPenalidadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorretamente() {
        Pregunta pregunta = new PreguntaVerdaderoFalsoConPenalidad("Argentina es el actual campeon mundial de futbol", new ArrayList<String>(Arrays.asList("Verdadero", "Falso")), new RespuestaVerdaderoFalso("Verdadero"));
        ArrayList<Respuesta> respuestaDeJugadores = new ArrayList<Respuesta>(Arrays.asList(new RespuestaVerdaderoFalso("Verdadero"), new RespuestaVerdaderoFalso("Falso")));
        Resultado resultado = pregunta.responder(respuestaDeJugadores);

        int puntosDelJugadorUno = 1;
        int puntosDelJugadorDos = -1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
    }

}
