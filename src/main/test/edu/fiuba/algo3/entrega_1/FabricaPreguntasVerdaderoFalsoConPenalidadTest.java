package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasVerdaderoFalsoConPenalidadTest {
    private static FabricaPreguntasVerdaderoFalsoConPenalidad fabrica;
    private static PreguntaVerdaderoFalsoConPenalidad pregunta;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntasVerdaderoFalsoConPenalidad();
        int id = 5;
        String tema = "Computacion";
        String enunciado = "Smalltalk es un lenguaje de programación muerto";
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(2);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Verdadero");
        opciones.add("Falso");
        String textoRespuesta = "Eee...  no vimos nada!";

        pregunta = (PreguntaVerdaderoFalsoConPenalidad) fabrica.crearPregunta(id,tema,enunciado,respuestaCorrecta,opciones,textoRespuesta);
    }

    @Test
    public void crearPreguntaVerdaderoFalsoConPenalidad() {
        setup();
        assertNotNull(pregunta);
    }
    
}
