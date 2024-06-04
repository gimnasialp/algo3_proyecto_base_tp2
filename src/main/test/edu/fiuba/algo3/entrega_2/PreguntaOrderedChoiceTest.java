package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.tp2.modelo.PreguntaOrderedChoice;
import edu.fiuba.algo3.tp2.modelo.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {

    private String enunciado;
    private List<String> opciones;
    private List<Integer> opcionesCorrectas;
    private PreguntaOrderedChoice preguntaOC;

    public PreguntaOrderedChoiceTest() {
        this.enunciado = "El nivel educativo es es...";
        this.opciones = Arrays.asList("Primaria", "Secundaria", "Terciario/Universitario");
        this.opcionesCorrectas = Arrays.asList(1, 2, 3);
        this.preguntaOC = new PreguntaOrderedChoice(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    @Test
    public void OrderedChoiceRecibeUnaListaDeRespuestasYAsignaPuntosCorrectamente() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(this.opcionesCorrectas);
        RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList(3, 2, 1));
        assertEquals(Arrays.asList(1, 0), this.preguntaOC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

}
