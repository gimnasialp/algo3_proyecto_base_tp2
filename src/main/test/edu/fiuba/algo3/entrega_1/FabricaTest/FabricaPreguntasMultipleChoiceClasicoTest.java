package edu.fiuba.algo3.entrega_1.FabricaTest;

import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceClasico;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasMultipleChoiceClasicoTest {
    private static FabricaPreguntaMultipleChoiceClasico fabrica;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntaMultipleChoiceClasico();

    }

    @Test
    public void crearPreguntaPreguntaMultipleChoiceClasicoTest() {
        setup();
        assertNotNull(fabrica);
    }
}
