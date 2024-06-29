package edu.fiuba.algo3.entrega_3.PruebasIntegrales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CasoJuegoAnuladorYExclusividadTest {


    public void test(){

        //arrancamos con multiplicadores, aplica a preguntas con penalidad
        //VFPenalidad(VF id=10) correcta=1
        //LectorPreguntasJson lector = new LectorPreguntasJson();
        //ArrayList<Pregunta> preguntasLector = lector.generarPreguntas();
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

        //1 Pregunta(VF id=3)
        Pregunta preguntaVF = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();
        //2 Pregunta(VFP id=11)
        Pregunta preguntaMC = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();
        //3 Pregunta(MC id=11)
        Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(12)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVF, preguntaMC, preguntaVFP));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel"), new Jugador("lionel")));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limite);

        /*  Primer Partida */
        algoHoot.proximaPartida();
        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        ModificadorState modificadorExcl = new ExclusividadDePuntaje();
        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorExcl, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        ModificadorState modificadorExcl2 = new ExclusividadDePuntaje();
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl2, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        ModificadorState modificadorExcl3 = new ExclusividadDePuntaje();
        Respuesta respuestaJugadortres = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadortres);


        //,consulto si el MultiplicadorPorDos fue utilizado, me dara True
        // assertTrue(jugadores.get(0).mutiplicadorFueUtilizado(new MultiplicarPorDos()));
        //en cambio, si consulto si el MultiplicadorPorTres fue utilizado, y me dara false,
        //puedo utilizarlo para otra futura pregunta
        assertFalse(jugadores.get(0).multiplicadorFueUtilizado(new MultiplicarPorTres()));
        assertTrue(jugadores.get(0).multiplicadorFueUtilizado(new MultiplicarPorDos()));

        // ptos ganados al momento: JugadorUno cuenta con 2 pto y el jugadorDos -2
        /*  Segunda Partida */
        algoHoot.proximaPartida();
        partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        //Modificador multiplicadorPorDosJugadorUno2daPartida = new MultiplicarPorDos();
        Respuesta respuestaJugadorUno2daPartida  = new RespuestaVerdaderoFalso(1);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        //partidaActiva.activaModificador(multiplicadorPorDosJugadorUno2daPartida, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno2daPartida);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Multiplicador multiplicadorPorDosJugadorDos2daPartida = new MultiplicarPorTres();
        Respuesta respuestaJugadorDos2daPartida = new RespuestaVerdaderoFalso(0);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorDos2daPartida, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos2daPartida);

        //en 2da ronda, el jug1 gano 1 pto y el 2do -3
        //total jug1: 2 + 1: 3 y jug2: -2 +(-3)= -5
        assertTrue(jugadores.get(0).obtenerPuntaje()==3);
        assertTrue(jugadores.get(1).obtenerPuntaje()== -5);

        //El jugador Dos ya no tiene multiplicadores para usar
        assertTrue(jugadores.get(1).obtenerMultiplicadoresDisponibles().size()==0);

        //Las partidas pueden avanzarse en el desarrollo sin interaccion con
        //los jugadores, tengo una partida, ahora adelantare dos mas para llegar al mismo
        //numero de preguntas
        algoHoot.proximaPartida();
        //aca me quede sin preguntas, si intento avanzar dara una exception
        assertThrows(SinPreguntasDisponiblesException.class, () -> {
            algoHoot.proximaPartida();
        });

    }
}
