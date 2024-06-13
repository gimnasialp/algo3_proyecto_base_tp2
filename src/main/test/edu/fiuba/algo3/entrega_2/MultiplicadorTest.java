package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void unJugadorTieneDosPuntosYActivaElMultiplicadorPorDos () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorDos(), 0);

        int puntosDelJugadorEsperado = 4;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void unJugadorTieneDosPuntosYActivaElMultiplicadorPorTres () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorTres(), 0);

        int puntosDelJugadorEsperado = 6;

        assertEquals(puntosDelJugadorEsperado, resultado.obtenerPuntosDelJugador(0));

    }

    @Test
    public void deVariosJugadoresConDistintosPuntosSoloUnoActivaElMultiplicadorPorDos(){

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(5);
        resultado.agregarPuntos(1);

        resultado.usarModificador(new MultiplicarPorDos(), 2);

        int puntosDelJugadorUnoEsperado = 2;
        int puntosDelJugadorDosEsperado = 3;
        int puntosDelJugadorTresEsperado = 5*2;
        int puntosDelJugadorCuatroEsperado = 1;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatroEsperado, resultado.obtenerPuntosDelJugador(3));

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

        int puntosDelJugadorUnoEsperado = 2*2;
        int puntosDelJugadorDosEsperado = 3*2;
        int puntosDelJugadorTresEsperado = 5;
        int puntosDelJugadorCuatroEsperado = 1*2;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));
        assertEquals(puntosDelJugadorCuatroEsperado, resultado.obtenerPuntosDelJugador(3));

    }

}
