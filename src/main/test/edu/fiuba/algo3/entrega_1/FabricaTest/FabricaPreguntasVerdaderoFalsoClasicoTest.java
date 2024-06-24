package edu.fiuba.algo3.entrega_1.FabricaTest;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasVerdaderoFalsoClasicoTest {

    private static FabricaPreguntasVerdaderoFalso fabrica;
    private static PreguntaVerdaderoFalsoClasico pregunta;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntasVerdaderoFalso();
        int id = 5;
        String tema = "Computacion";
        String enunciado = "Smalltalk es un lenguaje de programación muerto";
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(2);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Verdadero");
        opciones.add("Falso");
        String textoRespuesta = "Eee...  no vimos nada!";

        pregunta = (PreguntaVerdaderoFalsoClasico) fabrica.crearPregunta(id,tema,enunciado,respuestaCorrecta,opciones,textoRespuesta);
    }
    @Test
    public void crearPreguntaVerdaderoFalsoClasico() {
        setup();
        assertEquals(PreguntaVerdaderoFalsoClasico.class, pregunta.getClass());
        assertNotNull(pregunta);
    }

}