package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificadorTest {

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
    public void TresJugadoresTienenDosPuntosYUnoActivaElAnuladorDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 2;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void TresJugadoresTienenDosPuntosYUnoActivaLaExclusividadDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 4;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

}
