package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.puntuacion.Puntuacion;
import edu.fiuba.algo3.tp2.Jugador;
import edu.fiuba.algo3.tp2.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuacionTest {


    @Test
    public void Test01CreoUnaPuntuacionYPidoElTotalDePuntosGuardados() {
        Puntuacion puntuacion = new Puntuacion();


        assertEquals(0,puntuacion.obtenerPuntos() );

    }
    @Test
    public void Test02CreoUnaPuntuacionLeAgrego100puntosYMenosCincuentaPuntosLuegoPidoTotalPuntos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(100);
        puntuacion.agregarPuntos(-50);

        assertEquals(50,puntuacion.obtenerPuntos() );

    }
    @Test
    public void Test03CreoUnaPuntuacionLeAgregoMenosCienpuntosYAgregoCincuentaPuntosLuegoPidoTotalPuntos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(-100);
        puntuacion.agregarPuntos(50);

        assertEquals(-50,puntuacion.obtenerPuntos() );

    }

    @Test
    public void Test04CreoUnaPuntuacionYLeAgregoPuntosNegativos() {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPuntos(-100);
        puntuacion.agregarPuntos(-250);
        puntuacion.agregarPuntos(-750);
        int puntuacionEsperada = -1100;

        assertEquals(puntuacionEsperada,puntuacion.obtenerPuntos() );

    }

}
