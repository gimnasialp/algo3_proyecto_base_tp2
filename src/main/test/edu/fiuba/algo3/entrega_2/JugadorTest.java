package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void leAsignoUnPuntoAUnJugador() {

        Jugador jugadorUno = new Jugador("Martin");

        jugadorUno.asignarPuntos(1);

        int puntosDelJugadorEsperado = 1;

        assertEquals(puntosDelJugadorEsperado, jugadorUno.obtenerPuntaje());
    }

    @Test
    public void leAsignoPuntosPositivosYNegativosAUnJugador() {

        Jugador jugadorUno = new Jugador("Martin");

        jugadorUno.asignarPuntos(10);
        jugadorUno.asignarPuntos(5);
        jugadorUno.asignarPuntos(-30);

        int puntosDelJugadorEsperado = 10 + 5 - 30;

        assertEquals(puntosDelJugadorEsperado, jugadorUno.obtenerPuntaje());

    }

    @Test
    public void dosJugadoresRecibenUnPuntoObtenidoDelResultadoDeUnaRonda() {

        Jugador jugadorUno = new Jugador("Martin");
        Jugador jugadorDos = new Jugador("Robert");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>(Arrays.asList(jugadorUno, jugadorDos));

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(1);
        resultado.agregarPuntos(1);

        resultado.asignarPuntosALosJugadores(jugadores);

        int puntosDelJugadorUnoEsperado = 1;
        int puntosDelJugadorDosEsperado = 1;

        assertEquals(puntosDelJugadorUnoEsperado, jugadorUno.obtenerPuntaje());
        assertEquals(puntosDelJugadorDosEsperado, jugadorDos.obtenerPuntaje());
    }

}
