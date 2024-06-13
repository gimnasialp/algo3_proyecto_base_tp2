package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void dosJugadoresRecibenUnPunto() {
        Jugador jugadorUno = new Jugador("Martin");
        Jugador jugadorDos = new Jugador("Robert");
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>(Arrays.asList(jugadorUno, jugadorDos));

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(1);
        resultado.agregarPuntos(1);

        resultado.asignarPuntos(jugadores);

        int puntosDelJugadorUnoEsperado = 1;
        int puntosDelJugadorDosEsperado = 1;

        assertEquals(puntosDelJugadorUnoEsperado, jugadorUno.obtenerPuntaje());
        assertEquals(puntosDelJugadorDosEsperado, jugadorDos.obtenerPuntaje());
    }
}
