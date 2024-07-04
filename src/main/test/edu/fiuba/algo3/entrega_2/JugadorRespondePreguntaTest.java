package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.Parser;
import edu.fiuba.algo3.modelo.Lector.ProveedorJsonPreguntas;
import edu.fiuba.algo3.modelo.Lector.VerdaderoFalsoClasicoParser;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorRespondePreguntaTest {

    private Pregunta preguntaVerdaderoFalsoClasicoUno;
    private Pregunta preguntaVerdaderoFalsoClasicoDos;
    private Jugador jugador;

    @BeforeEach
    public void setUpPreguntas() {
        this.jugador = new Jugador("Marianito");

        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");
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
