package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtroJugadorActivaLaExclusividadDePuntajeAfectandoAEseJugador () {

        Jugador jug1 = new Jugador("migue");jug1.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug2 = new Jugador("ang");//jug2.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug3 = new Jugador("leon");//jug3.aplicarNuevoModificador(new ExclusividadDePuntaje());
        List<Jugador> listJug = new ArrayList<>(Arrays.asList(jug1,jug2,jug3));

        Resultado resultadoo = new Resultado();
        resultadoo.agregarPuntos(0);
        resultadoo.agregarPuntos(2);
        resultadoo.agregarPuntos(0);
        resultadoo.usarModificador(new ExclusividadDePuntaje(), listJug);

        int puntosDelJugadorUnoEsperadoo = 0;
        int puntosDelJugadorDosEsperadoo = 4;
        int puntosDelJugadorTresEsperadoo = 0;

        assertEquals(puntosDelJugadorUnoEsperadoo, resultadoo.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperadoo, resultadoo.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperadoo, resultadoo.obtenerPuntosDelJugador(2));





        //
        Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);

        int puntosDelJugadorUnoEsperado = 0;
        int puntosDelJugadorDosEsperado = 4;
        int puntosDelJugadorTresEsperado = 0;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));

    }


    @Test
    public void tresJugadoresGanaronPuntosYUnJugadorActivaLaExclusividadDePuntajeNoAfectaANinguno () {

        //test aplicar nuevo de Migue
        Jugador jug1 = new Jugador("migue");jug1.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug2 = new Jugador("ang");//jug2.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug3 = new Jugador("leon");//jug3.aplicarNuevoModificador(new ExclusividadDePuntaje());
        List<Jugador> listJug = new ArrayList<>(Arrays.asList(jug1,jug2,jug3));

        Resultado resultadoo = new Resultado();
        resultadoo.agregarPuntos(5);
        resultadoo.agregarPuntos(2);
        resultadoo.agregarPuntos(3);
        resultadoo.usarModificador(new ExclusividadDePuntaje(), listJug);

        int puntosDelJugadorUnoEsperadoo = 5;
        int puntosDelJugadorDosEsperadoo = 2;
        int puntosDelJugadorTresEsperadoo = 3;

        assertEquals(puntosDelJugadorUnoEsperadoo, resultadoo.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperadoo, resultadoo.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperadoo, resultadoo.obtenerPuntosDelJugador(2));

        // FIN test aplicar nuevo de Migue



        Resultado resultado = new Resultado();
        resultado.agregarPuntos(5);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(3);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);

        int puntosDelJugadorUnoEsperado = 5;
        int puntosDelJugadorDosEsperado = 2;
        int puntosDelJugadorTresEsperado = 3;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtrosDosJugadoresActivanLaExclusividadDePuntajeDuplicandoSuEfecto () {

        //test aplicar nuevo de Migue
        Jugador jug1 = new Jugador("migue");jug1.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug2 = new Jugador("ang");//jug2.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug3 = new Jugador("centellas");jug3.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug4 = new Jugador("leon");jug4.aplicarNuevoModificador(new ExclusividadDePuntaje());


        List<Jugador> listJug = new ArrayList<>(Arrays.asList(jug1,jug2,jug3,jug4));

        Resultado resultadoo = new Resultado();
        resultadoo.agregarPuntos(0);
        resultadoo.agregarPuntos(2);
        resultadoo.agregarPuntos(0);
        resultadoo.agregarPuntos(0);
        resultadoo.usarModificador(new ExclusividadDePuntaje(), listJug);

        int puntosDelJugadorUnoEsperadoo = 0;
        int puntosDelJugadorDosEsperadoo = 2*2*3;
        int puntosDelJugadorTresEsperadoo = 0;

        assertEquals(puntosDelJugadorUnoEsperadoo, resultadoo.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperadoo, resultadoo.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperadoo, resultadoo.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorTresEsperadoo, resultadoo.obtenerPuntosDelJugador(3));


        //FIN test aplicar nuevo de Migue

  /*    falla test al ingresar un jugador mas
        Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(0);//
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 2);
        resultado.usarModificador(new ExclusividadDePuntaje(), 3);//

        int puntosDelJugadorUnoEsperado = 0;
        int puntosDelJugadorDosEsperado = (2*2)*2;
        int puntosDelJugadorTresEsperado = 0;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));
*/
    }


    @Test
    public void tresJugadoresGanaronPuntosYTodosLosJugadoresActivanLaExclusividadDePuntajeNoAfectaANignuno () {

        //test aplicar nuevo de Migue
        Jugador jug1 = new Jugador("migue");jug1.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug2 = new Jugador("ang");jug2.aplicarNuevoModificador(new ExclusividadDePuntaje());
        Jugador jug3 = new Jugador("centellas");jug3.aplicarNuevoModificador(new ExclusividadDePuntaje());


        List<Jugador> listJug = new ArrayList<>(Arrays.asList(jug1,jug2,jug3));

        Resultado resultadoo = new Resultado();
        resultadoo.agregarPuntos(4);
        resultadoo.agregarPuntos(2);
        resultadoo.agregarPuntos(5);
        resultadoo.usarModificador(new ExclusividadDePuntaje(), listJug);

        int puntosDelJugadorUnoEsperadoo = 4;
        int puntosDelJugadorDosEsperadoo = 2;
        int puntosDelJugadorTresEsperadoo = 5;

        assertEquals(puntosDelJugadorUnoEsperadoo, resultadoo.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperadoo, resultadoo.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperadoo, resultadoo.obtenerPuntosDelJugador(2));

        //FIN test aplicar nuevo de Migue

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(4);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(5);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);
        resultado.usarModificador(new ExclusividadDePuntaje(), 2);

        int puntosDelJugadorUnoEsperado = 4;
        int puntosDelJugadorDosEsperado = 2;
        int puntosDelJugadorTresEsperado = 5;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));

    }


}
