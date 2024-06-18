package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorRespondePreguntaTest {

    private Pregunta preguntaVerdaderoFalsoClasicoUno;
    private Pregunta preguntaVerdaderoFalsoClasicoDos;
    private Jugador jugador;

    @BeforeEach
    public void setUpPreguntas() {
        this.jugador = new Jugador("Marianito");

        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        this.preguntaVerdaderoFalsoClasicoUno = preguntas.stream().filter(p -> p.mismoId(3)).findFirst().get();
        this.preguntaVerdaderoFalsoClasicoDos = preguntas.stream().filter(p -> p.mismoId(5)).findFirst().get();
    }

    @Test
    public void unJugadorRespondeIncorrectamenteUnaPreguntaVerdaderoFalsoClasicoYRecibeCeroPuntos() {

        Respuesta respuestaDelJugador = new RespuestaVerdaderoFalso(1);
        Resultado resultado = preguntaVerdaderoFalsoClasicoUno.responder(new ArrayList<>(Arrays.asList(respuestaDelJugador)));
        resultado.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugador)));

        assertEquals(0, jugador.obtenerPuntaje());
    }

    @Test
    public void unJugadorRespondeCorrectamenteDosPreguntasVerdaderoFalsoClasicoYRecibeDosPuntos() {

        Respuesta primeraRespuestaDelJugador = new RespuestaVerdaderoFalso(2);
        Resultado resultadoUno = preguntaVerdaderoFalsoClasicoUno.responder(new ArrayList<>(Arrays.asList(primeraRespuestaDelJugador)));
        resultadoUno.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugador)));

        Respuesta segundaRespuestaDelJugador = new RespuestaVerdaderoFalso(2);
        Resultado resultadoDos = preguntaVerdaderoFalsoClasicoDos.responder(new ArrayList<>(Arrays.asList(segundaRespuestaDelJugador)));
        resultadoDos.asignarPuntosALosJugadores(new ArrayList<>(Arrays.asList(jugador)));

        assertEquals(2, jugador.obtenerPuntaje());
    }

}
