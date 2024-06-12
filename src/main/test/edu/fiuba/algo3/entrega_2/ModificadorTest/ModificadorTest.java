package edu.fiuba.algo3.entrega_2.ModificadorTest;

import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificadorTest {

    @Test
    public void tresJugadoresTienenDosPuntosYUnoActivaElAnuladorDePuntaje () {

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
    public void tresJugadoresTienenVariosPuntosYDosJugadoresActivanElAnuladorDePuntajeTodosRecibiranCeroPuntos () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(1);
        resultado.agregarPuntos(5);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);
        resultado.usarModificador(new AnuladorDePuntaje(), 2);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 0;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtroJugadorActivaLaExclusividadDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = 4;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void tresJugadoresGanaronPuntosYUnJugadorActivaLaExclusividadDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(5);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(3);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);

        int puntosDelJugadorUno = 5;
        int puntosDelJugadorDos = 2;
        int puntosDelJugadorTres = 3;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void deTresJugadoresSoloUnoGanoPuntosYOtrosDosJugadoresActivanLaExclusividadDePuntajeDuplicandoSuEfecto () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(0);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 2);

        int puntosDelJugadorUno = 0;
        int puntosDelJugadorDos = (2*2)*2;
        int puntosDelJugadorTres = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void tresJugadoresGanaronPuntosYTodosLosJugadoresActivanLaExclusividadDePuntajeNoAfectaANignuno () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(4);
        resultado.agregarPuntos(2);
        resultado.agregarPuntos(5);
        resultado.usarModificador(new ExclusividadDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);
        resultado.usarModificador(new ExclusividadDePuntaje(), 2);

        int puntosDelJugadorUno = 4;
        int puntosDelJugadorDos = 2;
        int puntosDelJugadorTres = 5;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));
        assertEquals(puntosDelJugadorTres, resultado.obtenerPuntosDelJugador(2));

    }

    @Test
    public void dosJugadoresGanaronPuntosYUnJugadorActivaMultiplicadorPorTresYOtroJugadorActivaElAnuladorDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        int puntosDelJugadorUno = (3*3)*0;
        int puntosDelJugadorDos = 2;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));

    }

    // un requerimiento del juego es que los jugadores no pueden activar un MultiplicadorPorDos (MultiplicadorPorTres) y
    // ExclusividadDePuntaje en una misma ronda

    @Test
    public void dosJugadoresGanaronPuntosYUnJugadorActivaAnuladorDePuntajeYOtroJugadorActivaLaExclusividadDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new AnuladorDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        int puntosDelJugadorUno = (3*2);
        int puntosDelJugadorDos = 0;

        assertEquals(puntosDelJugadorUno, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDos, resultado.obtenerPuntosDelJugador(1));

    }

}
