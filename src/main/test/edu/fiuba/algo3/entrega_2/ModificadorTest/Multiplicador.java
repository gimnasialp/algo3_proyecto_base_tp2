package edu.fiuba.algo3.entrega_2.ModificadorTest;

import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Multiplicador {

    @Test
    public void unJugadorTieneDosPuntosYActivaElMultiplicadorPorDos () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorDos(), 0);

        int puntosDelJugador = 4;

        assertEquals(puntosDelJugador, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void unJugadorTieneDosPuntosYActivaElMultiplicadorPorTres () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorTres(), 0);

        int puntosDelJugador = 6;

        assertEquals(puntosDelJugador, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void deVariosJugadoresConDistintosPuntosSoloUnoActivaElMultiplicadorPorDos(){

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(5);
        resultado.agregarPuntos(1);

        resultado.usarModificador(new MultiplicarPorDos(), 2);

        int puntosDelJugadorUno = 2;
        int puntosDelJugadorDos = 3;
        int puntosDelJugadorTres = 5*2;
        int puntosDelJugadorCuatro = 1;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatro, resultado.obtenerPuntosDelJugador(3));

    }

    @Test
    public void variosJugadoresConDistintosPuntosActivaronElMultiplicadorPorDos(){

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(5);
        resultado.agregarPuntos(1);

        resultado.usarModificador(new MultiplicarPorDos(), 0);
        resultado.usarModificador(new MultiplicarPorDos(), 1);
        resultado.usarModificador(new MultiplicarPorDos(), 3);

        int puntosDelJugadorUno = 2*2;
        int puntosDelJugadorDos = 3*2;
        int puntosDelJugadorTres = 5;
        int puntosDelJugadorCuatro = 1*2;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatro, resultado.obtenerPuntosDelJugador(3));

    }
}
