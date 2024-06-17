package edu.fiuba.algo3.entrega_2.LectorTest;

import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LectorTest {
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    @Test
    public void testLector() {

        LectorPreguntasJson lectorPreguntasJson = new LectorPreguntasJson();
        preguntas = lectorPreguntasJson.generarPreguntas();


        assertEquals(25, preguntas.size());
    }

}
