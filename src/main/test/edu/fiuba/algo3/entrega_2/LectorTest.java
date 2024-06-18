package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Lector.LectorPreguntasJson;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LectorTest {

    @Test
    public void lectorMeGenera25objetosDeTipoPregunta() {

        LectorPreguntasJson lectorPreguntasJson = new LectorPreguntasJson();

        ArrayList<Pregunta> preguntas = lectorPreguntasJson.generarPreguntas();

        assertEquals(25, preguntas.size());
    }

}
