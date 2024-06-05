package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.Fabricas.FabricaPreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice.MultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasMultipleChoiceConPenalidadTest {
    private static FabricaPreguntaMultipleChoiceConPenalidad fabrica;
    private static ArrayList<Respuesta> respuestas;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntaMultipleChoiceConPenalidad();
        respuestas = new ArrayList<>();
    }

    @Test
    public void crearPreguntaPreguntaMultipleChoiceConPenalidadTest() {
        setup();
        MultipleChoiceConPenalidad pregunta = (MultipleChoiceConPenalidad) fabrica.crearPregunta("Argentina es el actual Campeon Mundial", respuestas);
        assertNotNull(pregunta);
    }
}
