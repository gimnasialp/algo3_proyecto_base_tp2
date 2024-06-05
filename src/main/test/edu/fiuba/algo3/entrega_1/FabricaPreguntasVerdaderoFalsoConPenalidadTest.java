package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Preguntas.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Preguntas.VoF.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Preguntas.VoF.VerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaPreguntasVerdaderoFalsoConPenalidadTest {
    private static FabricaPreguntasVerdaderoFalso fabrica;
    private static ArrayList<Respuesta> respuestas;

    @BeforeAll
    public static void setup() {
        fabrica = new FabricaPreguntasVerdaderoFalso();
        respuestas = new ArrayList<>();
    }

    @Test
    public void crearPreguntaVerdaderoFalsoConPenalidad() {
        setup();
        VerdaderoFalsoConPenalidad pregunta = (VerdaderoFalsoConPenalidad) fabrica.crearPregunta("Argentina es el actual Campeon Mundial", respuestas);
        assertNotNull(pregunta);
    }
}
