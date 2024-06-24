package edu.fiuba.algo3.entrega_3.PruebasIntegrales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CasosJuegoCompleto {

    @Test
    public void test(){

        //arrancamos con multiplicadores, aplica a preguntas con penalidad
        //VFPenalidad(VF id=10) correcta=1
        LectorPreguntasJson lector = new LectorPreguntasJson();
        ArrayList<Pregunta> preguntasLector = lector.generarPreguntas();
        Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();
        //Segunda Pregunta(MCP id=11)
        Pregunta preguntaMCP = preguntasLector.stream().filter(p -> p.mismoId(11)).findFirst().get();
        //Tercera Pregunta(MCP id=14)
        Pregunta preguntaMCP2 = preguntasLector.stream().filter(p -> p.mismoId(14)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVFP,preguntaMCP,preguntaMCP2));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, preguntasLector,limite);

        /*  Primer Partida */
        algoHoot.proximaPartida();
        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        Jugador jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();
        Modificador multiplicadorPorDosJugadorUno = new MultiplicarPorDos();
        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorUno,jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();
        Modificador multiplicadorPorDosJugadorDos = new MultiplicarPorDos();
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(0);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorDos,jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        //mas alla de la partida, si intento acceder nuevamente a multiplicadorPorDos dara error
        assertTrue(jugadores.get(0).modificadorUtilizado(new MultiplicarPorDos()));
        //en cambio, el MUltiplX3 esta activo a usar ya que el jugador no lo tiene como utilizado
        assertFalse(jugadores.get(0).modificadorUtilizado(new MultiplicarPorTres()));


    }

}
