package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorTest {

    @Test
    public void tresJugadoresTienenDosPuntosYUnoActivaElAnuladorDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        int puntosDelJugadorUnoEsperado = 0;
        int puntosDelJugadorDosEsperado = 2;
        int puntosDelJugadorTresEsperado = 0;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void tresJugadoresTienenVariosPuntosYDosJugadoresActivanElAnuladorDePuntajeTodosRecibiranCeroPuntos () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(1);
        resultado.agregarPuntos(5);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);
        resultado.usarModificador(new AnuladorDePuntaje(), 2);

        int puntosDelJugadorUnoEsperado = 0;
        int puntosDelJugadorDosEsperado = 0;
        int puntosDelJugadorTresEsperado = 0;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTresEsperado, resultado.obtenerPuntosDelJugador(2));

    }
}
