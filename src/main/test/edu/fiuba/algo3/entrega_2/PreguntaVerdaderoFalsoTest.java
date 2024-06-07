package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
public class PreguntaVerdaderoFalsoTest {

    private final String enunciado;
    private final boolean respuestaCorrecta;
    private PreguntaVerdaderoFalso preguntaVF;

    public PreguntaVerdaderoFalsoTest() {
        this.enunciado = "La manzana es azul";
        this.respuestaCorrecta = false;
    }

    private void crearVerdaderoFalsoClasico() {
        this.preguntaVF = PreguntaVerdaderoFalso.Clasico(this.enunciado, this.respuestaCorrecta);
    }

    private void crearVerdaderoFalsoPenalidad() {
        this.preguntaVF = PreguntaVerdaderoFalso.Penalidad(this.enunciado, this.respuestaCorrecta);
    }

    // Clasico
    @Test
    public void test01UnaPreguntaVFCPuedeCrearseSiSeIndicaLaRtaCorreta(){
        crearVerdaderoFalsoClasico();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(false);
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test02UnaPreguntaVFCRecibeUnaListaDeRespuestasYAsignaPuntos() {
        crearVerdaderoFalsoClasico();
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);
        assertEquals(Arrays.asList(1, 0), this.preguntaVF.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    // Penalidad
    @Test
    public void test03UnaPreguntaVFPPuedeCrearseSiSeIndicaLaRtaCorrecta(){
        crearVerdaderoFalsoPenalidad();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(false);
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test04UnaPreguntaVFPRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearVerdaderoFalsoPenalidad();
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);
        assertEquals(Arrays.asList(-1, 1), this.preguntaVF.responder(Arrays.asList(respuestaIncorrecta, respuestaCorrecta)));
    }
}
*/