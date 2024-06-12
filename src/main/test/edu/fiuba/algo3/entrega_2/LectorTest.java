package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LectorTest {
    private ArrayList<Pregunta> preguntas;
    @Test
    public void testLector() {

        LectorPreguntasJson lectorPreguntasJson = new LectorPreguntasJson();
        preguntas = lectorPreguntasJson.generarPreguntas();


        assertEquals(2, preguntas.size());
    }

}
