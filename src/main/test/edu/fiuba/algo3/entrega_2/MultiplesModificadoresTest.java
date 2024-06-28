package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorTres;
import edu.fiuba.algo3.modelo.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesModificadoresTest {

    @Test
    public void dosJugadoresGanaronPuntosYUnJugadorActivaMultiplicadorPorTresYOtroJugadorActivaElAnuladorDePuntaje () {
/*
        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new MultiplicarPorTres(), 0);
        resultado.usarModificador(new AnuladorDePuntaje(), 1);

        int puntosDelJugadorUnoEsperado = (3*3)*0;
        int puntosDelJugadorDosEsperado = 2;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));
*/
    }

    // un requerimiento del juego es que los jugadores no pueden activar un MultiplicadorPorDos (MultiplicadorPorTres) y
    // ExclusividadDePuntaje en una misma ronda

    /*
    @Test
    public void dosJugadoresGanaronPuntosYUnJugadorActivaAnuladorDePuntajeYOtroJugadorActivaLaExclusividadDePuntaje () {

        Resultado resultado = new Resultado();
        resultado.agregarPuntos(3);
        resultado.agregarPuntos(2);
        resultado.usarModificador(new AnuladorDePuntaje(), 0);
        resultado.usarModificador(new ExclusividadDePuntaje(), 1);

        int puntosDelJugadorUnoEsperado = (3*2);
        int puntosDelJugadorDosEsperado = 0;

        assertEquals(puntosDelJugadorUnoEsperado, resultado.obtenerPuntosDelJugador(0));
        assertEquals(puntosDelJugadorDosEsperado, resultado.obtenerPuntosDelJugador(1));

    }
*/
}


