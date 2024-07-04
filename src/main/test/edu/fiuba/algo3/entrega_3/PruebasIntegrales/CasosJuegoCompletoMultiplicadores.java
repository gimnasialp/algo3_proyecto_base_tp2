package edu.fiuba.algo3.entrega_3.PruebasIntegrales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.MultipleChoicePenalidadParser;
import edu.fiuba.algo3.modelo.Lector.Parser;
import edu.fiuba.algo3.modelo.Lector.ProveedorJsonPreguntas;
import edu.fiuba.algo3.modelo.Lector.VerdaderoFalsoConPenalidadParser;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CasosJuegoCompletoMultiplicadores {

    @Test
    public void juegoCompletoConPenalidadesYMultiplicadores() {

        //arrancamos con multiplicadores, aplica a preguntas con penalidad
        //VFPenalidad(VF id=10) correcta=1
        //LectorPreguntasJson lector = new LectorPreguntasJson();
        //ArrayList<Pregunta> preguntasLector = lector.generarPreguntas();
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

        //1 Pregunta(MCP id=11)
        Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();
        //2 Pregunta(MCP id=11)
        Pregunta preguntaVFP2 = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();
        //3 Pregunta(MCP id=11)
        Pregunta preguntaVFP3 = preguntasLector.stream().filter(p -> p.mismoId(10)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVFP, preguntaVFP2, preguntaVFP3));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"), new Jugador("Angel")));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limite);

        /*  Primer Partida */
        algoHoot.proximaPartida();
        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Multiplicador multiplicadorPorDosJugadorUno = new MultiplicarPorDos();
        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorUno, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Multiplicador multiplicadorPorDosJugadorDos = new MultiplicarPorDos();
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorDos, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

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
        Respuesta respuestaJugadorUno2daPartida = new RespuestaVerdaderoFalso(1);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        //partidaActiva.activaModificador(multiplicadorPorDosJugadorUno2daPartida, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno2daPartida);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Multiplicador multiplicadorPorDosJugadorDos2daPartida = new MultiplicarPorTres();
        Respuesta respuestaJugadorDos2daPartida = new RespuestaVerdaderoFalso(2);
        //antes de ser activado Multiplicador, se validara por vista o Controlador si el Multiplicador solicitado esta disponible
        partidaActiva.activaMultiplicador(multiplicadorPorDosJugadorDos2daPartida, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos2daPartida);

        //en 2da ronda, el jug1 gano 1 pto y el 2do -3
        //total jug1: 2 + 1: 3 y jug2: -2 +(-3)= -5
        assertTrue(jugadores.get(0).obtenerPuntaje() == 3);
        assertTrue(jugadores.get(1).obtenerPuntaje() == -5);

        //El jugador Dos ya no tiene multiplicadores para usar
        assertTrue(jugadores.get(1).obtenerMultiplicadoresDisponibles().size() == 0);

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
