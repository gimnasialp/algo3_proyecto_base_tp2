package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Preguntas.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasVerdaderoFalsoClasicoTest {

    private static FabricaPreguntasVerdaderoFalso fabrica;
    private static ArrayList<Respuesta> respuestas;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntasVerdaderoFalso();
        respuestas = new ArrayList<>();
    }

    @Test
    public void crearPreguntaVerdaderoFalsoClasico() {
        setup();

        VerdaderoFalsoClasico pregunta = (VerdaderoFalsoClasico) fabrica.crearPregunta("Argentina es el actual Campeon Mundial", respuestas);
        assertNotNull(pregunta);
    }

}
