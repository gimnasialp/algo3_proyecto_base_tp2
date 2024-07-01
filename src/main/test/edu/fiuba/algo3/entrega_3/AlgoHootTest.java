package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.LimitadorPorPuntos;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Limite.PuntosDefinidosDecorator;
//import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicadorPorUno;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AlgoHootTest {


    @Test
    public void testJuegoLimiteTotalPreguntasConDosJugadoresHastaTerminarJuego(){

        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        int idPregunta = 16;
        String tema = "DEPORTES";
        String textoRepuesta = "Argentina gano mundial de futbol en 2022";
        Pregunta preguntaUno = new PreguntaVerdaderoFalsoClasico(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        Pregunta preguntaDos = new PreguntaVerdaderoFalsoClasico(++idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaUno,preguntaDos));
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));

        //EL limite sera la cantidad final de Preguntas
        Limite limite = new LimiteFinalPreguntas(preguntas);
        AlgoHoot algoHoot = new AlgoHoot(jugadores,limite);

        /*  Primer Partida */
        // Empezamos con un Verdadero Falso Clasico linea 33
        algoHoot.proximaPartida();

        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador();
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();

        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();

        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);

        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        assertTrue(partidaActiva.jugadorConMasPuntos().getNombre().equals("Migue"));
        assertTrue(partidaActiva.jugadorConMasPuntos().obtenerPuntaje() == 1);

        /*  Segunda Partida */
        //Siguiente Partida(2da pregunta del juego para jugadores)
        algoHoot.proximaPartida();

        partidaActiva = algoHoot.obtenerPartidaActiva();

        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();

        respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();

        respuestaJugadorDos = new RespuestaVerdaderoFalso(1);

        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        assertTrue(partidaActiva.jugadorConMasPuntos().getNombre().equals("Migue"));
        assertTrue(partidaActiva.jugadorConMasPuntos().obtenerPuntaje()== 2);

        //Hasta el momento MIgue tiene 2 puntos y angel tiene 1
        //si quiero continuar la siguiente partida, no podré
        // ya que se usaron la totalidad de preguntas(2)
        //y el juego debe terminar

        assertThrows(SinPreguntasDisponiblesException.class, () -> {
            algoHoot.proximaPartida();
        });
    }

    @Test
    public void testJuegoLimiteNumeroPuntosconPreguntasOCyGCconDosJugadoresHastaTerminarJuego(){

        //Primera pregunta(OrderedChoice id=17)
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

        Pregunta preguntaOC = preguntasLector.stream().filter(p -> p.mismoId(17)).findFirst().get();
        //Segunda Pregunta(GroupChoice id=18)
        Pregunta preguntaGC = preguntasLector.stream().filter(p -> p.mismoId(18)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaOC,preguntaGC));
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));

        //EL limite sera puntaje igual a 1
        int puntoLimite=1;
        Limite limite =  new LimitadorPorPuntos( preguntas);
        Limite limiteDecorator =new PuntosDefinidosDecorator(limite, preguntas,  puntoLimite);

        AlgoHoot algoHoot = new AlgoHoot(jugadores,limiteDecorator);

        /*  Primer Partida */
        // Empezamos con un Verdadero Falso Clasico linea 33
        algoHoot.proximaPartida();

        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador();
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();

        Respuesta respuestaJugadorUno = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(1, 3, 4, 6, 5, 2)));
        partidaActiva.agregarRespuesta(respuestaJugadorUno);  //int puntosDelJugadorEsperado = 1;

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();

        Respuesta respuestaJugadorDos = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList(2, 4, 3, 1, 5, 6)));
        partidaActiva.agregarRespuesta(respuestaJugadorDos);  //int puntosDelJugadorEsperado = 0;


        assertTrue(partidaActiva.jugadorConMasPuntos().getNombre().equals("Migue"));
        assertTrue(partidaActiva.jugadorConMasPuntos().obtenerPuntaje() == 1);

        //Hasta el momento MIgue tiene 1 punto y angel tiene 0
        //puedo continuar la siguiente partida, ya que no supere el limite de puntos(1)
        //si alguien responde bien en la siguiente partida(2da partida),
        //el juego terminara ya que se superaria el limite(1)
        /*  Segunda Partida */
        // Empezamos con un Verdadero Falso Clasico linea 33
        algoHoot.proximaPartida();

        partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();
        respuestaJugadorUno = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(3, 4, 6)));
        partidaActiva.agregarRespuesta(respuestaJugadorUno);  //int puntosDelJugadorEsperado = 1;

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();

        respuestaJugadorDos = new RespuestaGroupChoice(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(4, 5, 6)));
        partidaActiva.agregarRespuesta(respuestaJugadorDos);  //int puntosDelJugadorEsperado = 0;

        assertTrue(partidaActiva.jugadorConMasPuntos().getNombre().equals("Migue"));
        assertTrue(partidaActiva.jugadorConMasPuntos().obtenerPuntaje() == 2);

        //Hasta el momento MIgue tiene 2 puntos y angel tiene 0
        //si quiero continuar la siguiente partida, no podré
        // ya que se supero al limite de puntos (1)
        //y el juego debe terminar

        assertThrows(PuntajeMaximoSuperadoException.class, () -> {
            algoHoot.proximaPartida();;
        });
    }
}

