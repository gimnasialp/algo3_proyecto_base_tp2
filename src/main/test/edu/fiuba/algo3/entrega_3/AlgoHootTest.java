package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicadorPorUno;
import edu.fiuba.algo3.modelo.Partida.Contesta;
import edu.fiuba.algo3.modelo.Partida.Opcion;
import edu.fiuba.algo3.modelo.Partida.OpcionUnica;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoHootTest {

    @Test
    public void untest(){

        //
        int cantidadPreguntasFinal = 1;
        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        int idPregunta = 16;
        String tema = "DEPORTES";
        String textoRepuesta = "Argentina gano mundial de futbol en 2022";
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta,pregunta));
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        //
        AlgoHoot algoHoot = new AlgoHoot(jugadores, preguntas,limite);

        // Empezamos con un Verdadero Falso
        algoHoot.proximaPartida();

        Partida partidaActiva = algoHoot.obtenerPartidaActiva();

        partidaActiva.avanzoConSiguienteJugador();

        Jugador jugadorDePartidaActiva =partidaActiva.obtenerJugadorActivo();

        Opcion opcionJugadorUno =new OpcionUnica("Verdadero");

        List<Opcion> opcionesJugadorUno = new ArrayList<>();
        opcionesJugadorUno.add(opcionJugadorUno);

        Contesta contestaJugadorUno = new Contesta(opcionesJugadorUno);
        Modificador multiplicadorPorUno = new MultiplicadorPorUno();
    }
}
