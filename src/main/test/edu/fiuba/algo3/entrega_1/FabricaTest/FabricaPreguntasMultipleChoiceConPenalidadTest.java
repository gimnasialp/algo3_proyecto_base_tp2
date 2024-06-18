package edu.fiuba.algo3.entrega_1.FabricaTest;

import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceConPenalidad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasMultipleChoiceConPenalidadTest {
    private static FabricaPreguntaMultipleChoiceConPenalidad fabrica;


    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntaMultipleChoiceConPenalidad();

    }

    @Test
    public void crearPreguntaPreguntaMultipleChoiceConPenalidadTest() {
        setup();

        assertNotNull(fabrica);
    }
}
