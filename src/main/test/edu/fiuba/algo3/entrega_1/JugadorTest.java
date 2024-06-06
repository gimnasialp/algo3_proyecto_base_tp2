package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.tp2.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void Test01CreoUnJugadorSinPuntosYConsultoSusPuntos() {
        Jugador unJugador = new Jugador("Juan");
        int puntuacionEsperada = 0;
        assertEquals(puntuacionEsperada,unJugador.puntaje());

    }

    @Test
    public void Test02UnJugadorRecibeCincoVecesDiezPuntosYConsultoSusPuntos() {
        Jugador unJugador = new Jugador("");
        int puntuacionEsperada = 50;
        unJugador.agregarPuntuacion(10);
        unJugador.agregarPuntuacion(10);
        unJugador.agregarPuntuacion(10);
        unJugador.agregarPuntuacion(10);
        unJugador.agregarPuntuacion(10);
        assertEquals(puntuacionEsperada,unJugador.puntaje());

    }

}
