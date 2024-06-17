package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorRespondeTest {

    @Test
    public void unJugadorGeneraUnaRespuestaAUnaPreguntaVerdaderoFalsoYRecibeUnPunto() {

        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        Pregunta preguntaVerdaderoFalsoClasico = preguntas.stream().filter(p -> p.mismoId(3)).findFirst();

        Jugador jugador = new Jugador("Pablo");

        Respuesta respuestaDelJugador = new RespuestaVerdaderoFalso(1);

        Resultado resultado = preguntaVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(respuestaDelJugador)));

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugador)));

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void unJugadorRespondeDosPreguntasVerdaderoFalsoClasicosYRecibeDosPuntos() {
        Jugador jugador = new Jugador("Pablo");

        LectorPreguntasJson lector = new LectorPreguntasJson();

        ArrayList<Pregunta> preguntasUno = lector.generarPreguntas();
        Pregunta preguntaUnoVerdaderoFalsoClasico = preguntasUno.get(0);

        Respuesta primeraRespuestaDelJugador = new RespuestaVerdaderoFalso(2);

        Resultado resultadoUno = preguntaUnoVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(primeraRespuestaDelJugador)));

        resultadoUno.asignarPuntos(new ArrayList<>(Arrays.asList(jugador)));

        ArrayList<Pregunta> preguntasDos = lector.generarPreguntas();
        Pregunta preguntaDosVerdaderoFalsoClasico = preguntasDos.get(0);

        Respuesta segundaRespuestaDelJugador = new RespuestaVerdaderoFalso(2);

        Resultado resultadoDos = preguntaDosVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(segundaRespuestaDelJugador)));

        resultadoDos.asignarPuntos(new ArrayList<>(Arrays.asList(jugador)));

        assertEquals(2, jugador.obtenerPuntaje());
    }

    @Test
    public void dosJugadoresRespondenMalAUnaPreguntaVerdaderoFalsoClasicoYNoRecibenPuntos() {
        Jugador jugadorUno = new Jugador("Robert");
        Jugador jugadorDos = new Jugador("Camilo");

        LectorPreguntasJson lector = new LectorPreguntasJson();

        ArrayList<Pregunta> preguntasUno = lector.generarPreguntas();
        Pregunta preguntaVerdaderoFalsoClasico = preguntasUno.get(0);

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(2);
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        Resultado resultado = preguntaVerdaderoFalsoClasico.responder(new ArrayList<>(Arrays.asList(respuestaJugadorUno, respuestaJugadorDos)));

        resultado.usarModificador(new AnuladorDePuntaje(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        resultado.asignarPuntos(new ArrayList<>(Arrays.asList(jugadorUno, jugadorDos)));

        assertEquals(0, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }
}
