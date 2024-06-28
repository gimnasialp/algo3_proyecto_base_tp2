package edu.fiuba.algo3.entrega_3;


import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Excepciones.SinPreguntasDisponiblesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.*;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LimiteTest {

    /*@Test
    public void test_LimitarHastaFinDePreguntas_NoTengoMasPreguntasDeLimite(){
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
        Pregunta preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        assertEquals(cantidadPreguntasFinal,limite.preguntasRestantesLimite());
        preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        assertEquals(cantidadPreguntasFinal -1,limite.preguntasRestantesLimite());
    }*/

    @Test
    public void test_LimitarHastaFinDePreguntas_NoTengoMasPreguntasDeLimite(){
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
        Pregunta preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        //assertEquals(cantidadPreguntasFinal,limite.preguntasRestantesLimite());
        preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        //assertEquals(cantidadPreguntasFinal -1,limite.preguntasRestantesLimite());

        //si intento leer pregunta no existente, previamente limitada
        assertThrows(SinPreguntasDisponiblesException.class, limite::obtenerPreguntaSgte);
    }

    /*@Test
    public void test_LimitadorDeJuego_PorCantidadDePreguntas(){
        int cantidadPreguntasFinal = 1;
        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        int idPregunta = 16;
        String tema = "DEPORTES";
        String textoRepuesta = "Argentina gano mundial de futbol en 2022";
        Pregunta pregunta = new PreguntaVerdaderoFalsoClasico(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta,pregunta,pregunta,pregunta));
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));

        Limite limite = new LimitadorPorNumeroPreguntas(2, preguntas);

        Pregunta preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        assertEquals(cantidadPreguntasFinal,limite.preguntasRestantesLimite());
        preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        assertEquals(cantidadPreguntasFinal -1,limite.preguntasRestantesLimite());

        //si intento leer pregunta no existente, previamente limitada
        assertThrows(SinPreguntasDisponiblesException.class, limite::obtenerPreguntaSgte);

    }*/

    @Test
    public void test_LimitadorDeJuego_PorCantidadDePreguntas(){
        //int cantidadPreguntasFinal = 1;

        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");

        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel")));

        Limite limite = new LimitadorPorNumeroPreguntas(2, preguntas);

        Pregunta preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        //assertEquals(cantidadPreguntasFinal,limite.preguntasRestantesLimite());
        preguntaParaResponder = limite.preguntaNoLimitada(jugadores);
        //assertEquals(cantidadPreguntasFinal -1,limite.preguntasRestantesLimite());

        //si intento leer pregunta no existente, previamente limitada
        //assertThrows(SinPreguntasDisponiblesException.class, limite::obtenerPreguntaSgte);
        assertThrows(SinPreguntasDisponiblesException.class, () -> {
            limite.preguntaNoLimitada(jugadores);
        });
    }

    @Test
    public void test_LimitadorDeJuego_PorPuntos(){
        String enunciado = "Argentina es el actual campeon mundial de futbol";
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("Verdadero", "Falso"));
        Respuesta respuestaCorrecta = new RespuestaVerdaderoFalso(1);
        int idPregunta = 16;
        String tema = "DEPORTES";
        String textoRepuesta = "Argentina gano mundial de futbol en 2022";
        Pregunta preguntaUno = new PreguntaVerdaderoFalsoClasico(idPregunta++, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        Pregunta preguntaDos = new PreguntaVerdaderoFalsoClasico(idPregunta++, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        Pregunta preguntaTres = new PreguntaVerdaderoFalsoClasico(idPregunta++, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);
        Pregunta preguntaCuatro = new PreguntaVerdaderoFalsoClasico(idPregunta++, tema, enunciado, respuestaCorrecta, opciones, textoRepuesta);

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaUno,preguntaDos,preguntaTres,preguntaCuatro));
        Jugador jugadorUno = new Jugador("Migue");
        jugadorUno.asignarPuntos(0);
        Jugador jugadorDos = new Jugador("Angel");
        jugadorUno.asignarPuntos(0);
        List<Jugador> jugadores = new ArrayList<>(Arrays.asList(jugadorUno,jugadorDos));

        int puntoLimite=3;
        Limite limite =  new LimitadorPorPuntos( preguntas);
        Limite limiteDecorator =new PuntosDefinidosDecorator(limite, preguntas,  puntoLimite);

        //inicio Juego(1er partida), ambos comienzan con 0 ptos, se obtiene la 1er pregunta a contestar
        Pregunta preguntaParaResponder = limiteDecorator.preguntaNoLimitada(jugadores);
        assertEquals(preguntaParaResponder.getClass(),PreguntaVerdaderoFalsoClasico.class);
        //contestan primera pregunta(1ra partida)
        jugadorUno.asignarPuntos(2);
        jugadorDos.asignarPuntos(0);
         jugadores = new ArrayList<>(Arrays.asList(jugadorUno,jugadorDos));
        //fin primer partida, primer jugador ganó 2 ptos y el 2do ninguno, y el total seria
        //jugadorUno=2ptos y jugadorDos=0pts, el mayor pto es del jugadorDos pero No supera el limite=3
        //por tanto, puede seguir jugando(obtiene la siguiente pregunta, para partida 2)

        //obtener sig pregunta para sig ronda (2 preg-2da ronda)
         preguntaParaResponder = limiteDecorator.preguntaNoLimitada(jugadores);
        assertEquals(preguntaParaResponder.getClass(),PreguntaVerdaderoFalsoClasico.class);

        //contestan 2 pregunta(2da partida)
        jugadorUno.asignarPuntos(3);
        jugadorDos.asignarPuntos(2);
        jugadores = new ArrayList<>(Arrays.asList(jugadorUno,jugadorDos));
        //fin 2da partida, primer jugador ganó 2 ptos y el ganó 2, y el total seria
        //jugadorUno=5ptos y jugadorDos=2pts, el mayor pto es del jugadorUno y supera el limite=3
        //por tanto al intentar obtener sig. pregunta, lanza excepcion

        List<Jugador> finalJugadores = jugadores; //me lo pide el IDE, no deberia ser necesario crear otra variable.
        assertThrows(PuntajeMaximoSuperadoException.class, () -> {
            limiteDecorator.preguntaNoLimitada(finalJugadores);
        });

    }


}
