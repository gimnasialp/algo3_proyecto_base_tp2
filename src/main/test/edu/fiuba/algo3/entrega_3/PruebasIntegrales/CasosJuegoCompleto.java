package edu.fiuba.algo3.entrega_3.PruebasIntegrales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Lector.Parser;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CasosJuegoCompleto {

    @Test
    public void juegoCompletoConPenalidades() {

        //arrancamos con multiplicadores, aplica a preguntas con penalidad
        //VFPenalidad(VF id=10) correcta=1
        //LectorPreguntasJson lector = new LectorPreguntasJson();
        //ArrayList<Pregunta> preguntasLector = lector.generarPreguntas();
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");


        Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();
        //Segunda Pregunta(MCP id=11)
        Pregunta preguntaMCP = preguntasLector.stream().filter(p -> p.mismoId(11)).findFirst().get();
        //Tercera Pregunta(MCP id=14)
        Pregunta preguntaMCP2 = preguntasLector.stream().filter(p -> p.mismoId(14)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVFP, preguntaMCP, preguntaMCP2));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"), new Jugador("Angel")));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limite);

        /*  Primer Partida */
        algoHoot.proximaPartida();
        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador multiplicadorPorDosJugadorUno = new MultiplicarPorDos();
        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorUno, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador multiplicadorPorDosJugadorDos = new MultiplicarPorDos();
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(0);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorDos, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        //,consulto si el MultiplicadorPorDos fue utilizado, me dara True
        assertTrue(jugadores.get(0).modificadorUtilizado(new MultiplicarPorDos()));
        //en cambio, si consulto si el MultiplicadorPorTres fue utilizado, y me dara false,
        //puedo utilizarlo para otra futura pregunta
        assertFalse(jugadores.get(0).modificadorUtilizado(new MultiplicarPorTres()));

        //Las partidas pueden avanzarse en el desarrollo sin interaccion con
        //los jugadores, tengo una partida, ahora adelantare dos mas para llegar al mismo
        //numero de preguntas
        algoHoot.proximaPartida();
        algoHoot.proximaPartida();
        //aca me quede sin preguntas, si intento avanzar dara una exception
        assertThrows(SinPreguntasDisponiblesException.class, () -> {
            algoHoot.proximaPartida();
        });

    }



}
