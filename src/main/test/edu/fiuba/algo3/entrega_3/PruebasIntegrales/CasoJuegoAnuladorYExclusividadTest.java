package edu.fiuba.algo3.entrega_3.PruebasIntegrales;

import edu.fiuba.algo3.modelo.AlgoHoot;
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

    @Test
    public void usoDeExclusividadesyComprobacionesDeUso(){

        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

        //1 Pregunta(VF id=3)
        Pregunta preguntaVF = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();
        //2 Pregunta(VFP2 id=3)
        Pregunta preguntaVF2 = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();
        //3 Pregunta(MC id=11)
        Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(12)).findFirst().get();

        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVF, preguntaVF2, preguntaVFP));

        Limite limite = new LimiteFinalPreguntas(preguntas);
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel"), new Jugador("lionel")));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limite);

        /*  Primer Partida */
        algoHoot.proximaPartida();
        Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorExcl = new ExclusividadDePuntaje();
        Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorExcl, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorExcl2 = new ExclusividadDePuntaje();
        Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl2, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

        //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorExcl3 = new ExclusividadDePuntaje();
        Respuesta respuestaJugadortres = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadortres);


        //solo el 2do y tercero  contestaron bien, por lo que los puntos serian:
        //1er: 0pt, 2do: 1pto, 3ro:1pto
        //los tres jugadores pidieron exclusividad
       // conforme al juego, no se aplica comodin a ninguno,
         //       los ptos permanecen intactos .
        assertTrue(jugadores.get(0).obtenerPuntaje() == 0);
        assertTrue(jugadores.get(1).obtenerPuntaje() == 1);
        assertTrue(jugadores.get(2).obtenerPuntaje() == 1);
        //Los tres aun tiene habilitado Exclusividad para usar(ya que el limite es >2)
        assertTrue(jugadores.get(0).habilitado(new ExclusividadDePuntaje()));
        assertTrue(jugadores.get(1).habilitado(new ExclusividadDePuntaje()));
        assertTrue(jugadores.get(2).habilitado(new ExclusividadDePuntaje()));
        //y puedo saber que modificador usaron en la actual partida
        assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());
        assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());
        assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());

        /*  Segunda Partida */
        algoHoot.proximaPartida();
        partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador();
        Jugador jugadorUno2daPart = partidaActiva.obtenerJugadorActivo();
//        ModificadorState modificadorJugUno2daPart = new ExclusividadDePuntaje();
        Respuesta respuestaJugUno2daPart = new RespuestaVerdaderoFalso(2);
  //      partidaActiva.activaModificador(modificadorJugUno2daPart, jugadorUno2daPart);
        partidaActiva.agregarRespuesta(respuestaJugUno2daPart);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorJugDos2daPart = new ExclusividadDePuntaje();
        Respuesta respuestaJugDos2daPart = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorJugDos2daPart, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugDos2daPart);

        //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorJugTres2daPart = new ExclusividadDePuntaje();
        Respuesta respuestaJugTres2daPart = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorJugTres2daPart, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugTres2daPart);

        // de la primera partida venian asi: j1:0ptos;j2:1pto;j3:1pto
        // resultados del juego j1:1 ;j2:0 ; j3:0
        // como j2 y j3 activaron exclus. y contestaron mal
        //se aplica en j1 el doble con el efecto *cantidadJugadoresQuePidieronExcl(2)
        //el pto de la partida seria j1:1*2*2(cantidad jug.que pidieron excl):4 j2:0 ; j3:0
        //la suma total da (poniendo en 1er termino ptos de la anterior partida):
        //  j1:0+4:4 ; j2:1+0 ; j3:1+0
        assertTrue(jugadores.get(0).obtenerPuntaje() == 4);
        assertTrue(jugadores.get(1).obtenerPuntaje() == 1);
        assertTrue(jugadores.get(2).obtenerPuntaje() == 1);

        //De los tres jugadores, solo el primero tiene habilitado Exclusividad(ya usaron los dos usos de limite)
        assertTrue(jugadores.get(0).habilitado(new ExclusividadDePuntaje()));
        assertFalse(jugadores.get(1).habilitado(new ExclusividadDePuntaje()));
        assertFalse(jugadores.get(2).habilitado(new ExclusividadDePuntaje()));

        //y sus actuales modificadores usados
        assertEquals(jugadores.get(0).obtenerModificadorActual(), new ModificadorNulo());
        assertEquals(jugadores.get(1).obtenerModificadorActual(), new ExclusividadDePuntaje());
        assertEquals(jugadores.get(2).obtenerModificadorActual(), new ExclusividadDePuntaje());
    }


    @Test
    public void usoExclusividadyAnuladoresConComprobacionesDeUso(){

    HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
    ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

    ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

    //Uso mismas preguntas para acelerar test
    Pregunta preguntaVF = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();
    Pregunta preguntaVF2 = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();
    Pregunta preguntaVFP = preguntasLector.stream().filter(p -> p.mismoId(3)).findFirst().get();

    ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(preguntaVF, preguntaVF2, preguntaVFP));

    Limite limite = new LimiteFinalPreguntas(preguntas);
    ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(new Jugador("Migue"),new Jugador("Angel"), new Jugador("lionel")));
    AlgoHoot algoHoot = new AlgoHoot(jugadores, limite);

    /*  Primer Partida */
        algoHoot.proximaPartida();
    Partida partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
    Jugador jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
    Modificador modificadorExcl = new ExclusividadDePuntaje();
    Respuesta respuestaJugadorUno = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorExcl, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorUno);

    //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
    jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
    Modificador modificadorExcl2 = new ExclusividadDePuntaje();
    Respuesta respuestaJugadorDos = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl2, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadorDos);

    //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
    jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
    Modificador modificadorExcl3 = new ExclusividadDePuntaje();
    Respuesta respuestaJugadortres = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorExcl3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugadortres);


    //solo el 2do y tercero  contestaron bien, por lo que los puntos serian:
    //1er: 0pt, 2do: 1pto, 3ro:1pto
    //los tres jugadores pidieron exclusividad
    // conforme al juego, no se aplica comodin a ninguno,
    //       los ptos permanecen intactos .
    assertTrue(jugadores.get(0).obtenerPuntaje() == 0);
    assertTrue(jugadores.get(1).obtenerPuntaje() == 1);
    assertTrue(jugadores.get(2).obtenerPuntaje() == 1);
    //Los tres aun tiene habilitado Exclusividad para usar(ya que el limite es >2)
    assertTrue(jugadores.get(0).habilitado(new ExclusividadDePuntaje()));
    assertTrue(jugadores.get(1).habilitado(new ExclusividadDePuntaje()));
    assertTrue(jugadores.get(2).habilitado(new ExclusividadDePuntaje()));
    //y puedo saber que modificador usaron en la actual partida
    assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());
    assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());
    assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());


    /*  Segunda Partida */
        algoHoot.proximaPartida();
    partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador();
    Jugador jugadorUno2daPart = partidaActiva.obtenerJugadorActivo();
    Modificador modificadorJugUno2daPart = new AnuladorDePuntaje();
    Respuesta respuestaJugUno2daPart = new RespuestaVerdaderoFalso(2);
    partidaActiva.activaModificador(modificadorJugUno2daPart, jugadorUno2daPart);
    partidaActiva.agregarRespuesta(respuestaJugUno2daPart);

    //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
    jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
    Respuesta respuestaJugDos2daPart = new RespuestaVerdaderoFalso(1);
//        partidaActiva.activaModificador(modificadorJugDos2daPart, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugDos2daPart);

    //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
    jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
  //  ModificadorState modificadorJugTres2daPart = new ExclusividadDePuntaje();
    Respuesta respuestaJugTres2daPart = new RespuestaVerdaderoFalso(1);
    //    partidaActiva.activaModificador(modificadorJugTres2daPart, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestaJugTres2daPart);

    // de la primera partida venian asi: j1:0ptos;j2:1pto;j3:1pto
    // resultados del juego j1:1 ;j2:0 ; j3:0
    // como solo j1 activo Anulador, afectara al resto de jugadores
    //en este caso el afectado es el jug3 , que fue el que contesto bien de los demas
    //el pto de la partida seria j1:1 j2:0 ; j3:1--> 0
    //la suma total da (poniendo en 1er termino ptos de la anterior partida):
    //  j1:0+1:1 ; j2:1+0:1 ; j3:1+0:1
    assertTrue(jugadores.get(0).obtenerPuntaje() == 1);
    assertTrue(jugadores.get(1).obtenerPuntaje() == 1);
    assertTrue(jugadores.get(2).obtenerPuntaje() == 1);

    //De los tres jugadores, solo el primero tiene inHabilitado Anulador para sig. partida
    assertFalse(jugadores.get(0).habilitado(new AnuladorDePuntaje()));
    assertTrue(jugadores.get(1).habilitado(new AnuladorDePuntaje()));
    assertTrue(jugadores.get(2).habilitado(new AnuladorDePuntaje()));

    //y sus actuales modificadores usados
    assertEquals(jugadores.get(0).obtenerModificadorActual(), new AnuladorDePuntaje());
    assertEquals(jugadores.get(1).obtenerModificadorActual(), new ModificadorNulo());
    assertEquals(jugadores.get(2).obtenerModificadorActual(), new ModificadorNulo());

        /* Tercera Partida*/
        algoHoot.proximaPartida();
        partidaActiva = algoHoot.obtenerPartidaActiva();
        partidaActiva.avanzoConSiguienteJugador(); //EN este caso es el primer jugador
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorExcljug1Part3 = new ExclusividadDePuntaje();
        Respuesta respuestajug1Part3 = new RespuestaVerdaderoFalso(1);
        partidaActiva.activaModificador(modificadorExcljug1Part3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestajug1Part3);

        //pasa a jugar segundo Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorjug2Part3 = new AnuladorDePuntaje();
        Respuesta respuestajug2Part3  = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorjug2Part3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestajug2Part3);

        //pasa a jugar 3 Jugador
        partidaActiva.avanzoConSiguienteJugador();
        jugadorDePartidaActiva = partidaActiva.obtenerJugadorActivo();
        Modificador modificadorjug3Part3  = new AnuladorDePuntaje();
        Respuesta respuestajug3Part3  = new RespuestaVerdaderoFalso(2);
        partidaActiva.activaModificador(modificadorjug3Part3, jugadorDePartidaActiva);
        partidaActiva.agregarRespuesta(respuestajug3Part3);

        //jug1 pidio exclus. pero como hubo mas de 1 jugador que contesto bien
        //no se aplico beneficio de exclusividad, quedaron con sus ptos ganados de la partida
        // es decir jug1=0(habia contestado mal)  jug2=1;jug3=1
        //Luego, se verifica anulador, la pidieron los jug2 y jug3
        //con los puntos de partida ya mostrados en linea 284, los anuladores se ajustaron asi:
        //jug2 anulo ptos de jug3 y jug3 anulo los ptos de jug2, en el jug1, al haber contestado mal no le afecto los anuladores de los otros jugadores.
        //los ptos de partida quedan asi: jug1:0 , jug2:0 y jug3:0
        //ptos totales al momento Jug1:1+0:1 Jug2:1+0= Jug3:1+0
        assertTrue(jugadores.get(0).obtenerPuntaje() == 1);
        assertTrue(jugadores.get(1).obtenerPuntaje() == 1);
        assertTrue(jugadores.get(2).obtenerPuntaje() == 1);

        //Los tres tienen inHabilitado Anulador para la sig. partida
        assertFalse(jugadores.get(0).habilitado(new AnuladorDePuntaje()));
        assertFalse(jugadores.get(1).habilitado(new AnuladorDePuntaje()));
        assertFalse(jugadores.get(2).habilitado(new AnuladorDePuntaje()));

        //y sus actuales modificadores usados
        assertEquals(jugadores.get(0).obtenerModificadorActual(), new ExclusividadDePuntaje());
        assertEquals(jugadores.get(1).obtenerModificadorActual(), new AnuladorDePuntaje());
        assertEquals(jugadores.get(2).obtenerModificadorActual(), new AnuladorDePuntaje());

    }
}
