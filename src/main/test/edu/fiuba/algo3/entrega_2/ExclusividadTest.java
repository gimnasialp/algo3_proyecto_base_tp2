package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtroJugadorActivaLaExclusividadDePuntajeAfectandoAEseJugador () {
/*
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
*/
    }


    @Test
    public void tresJugadoresGanaronPuntosYUnJugadorActivaLaExclusividadDePuntajeNoAfectaANinguno () {

     /*   Resultado resultado = new Resultado();
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
*/
    }

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtrosDosJugadoresActivanLaExclusividadDePuntajeDuplicandoSuEfecto () {

      /*  Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 2);

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
/*
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
*/
    }


}
