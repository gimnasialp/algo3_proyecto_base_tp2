package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.Fabricas.FabricaPreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice.MultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasMultipleChoiceClasicoTest {
    private static FabricaPreguntaMultipleChoiceClasico fabrica;
    private static ArrayList<Respuesta> respuestas;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntaMultipleChoiceClasico();
        respuestas = new ArrayList<>();
    }

    @Test
    public void crearPreguntaPreguntaMultipleChoiceClasicoTest() {
        setup();
        MultipleChoiceClasico pregunta = (MultipleChoiceClasico) fabrica.crearPregunta("Argentina es el actual Campeon Mundial", respuestas);
        assertNotNull(pregunta);
    }
}
