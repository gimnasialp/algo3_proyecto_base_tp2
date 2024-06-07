package edu.fiuba.algo3.entrega_2.Respuesta;

import edu.fiuba.algo3.tp2.modelo.Respuesta;
import edu.fiuba.algo3.tp2.modelo.RespuestaNoCompatibleException;
import edu.fiuba.algo3.tp2.modelo.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2.modelo.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaOrderedChoiceTest {


    private RespuestaOrderedChoice respuestaCorrecta;

    public void setupRespuestaCorrecta() {
        this.respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
    }

    @Test
    public void test01DosRespuestasOrderedChoiceSonIgualesSiAmbasTienenSusOpcionesEnElMismoOrden() {
        setupRespuestaCorrecta();
        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
        assertTrue(respuestaCorrecta.equals(respuesta));
    }

    @Test
    public void test02UnaRespuestaOrderedChoiceCorrectaValeUnPunto() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1, 3));
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test03UnaRespuestaOrderedChoiceIncorrectaValeCeroPuntos() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 3, 1));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04UnaPreguntaGCPuntua0SiNoSeEnviaLaTotalidadDeElementos() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(4, 2, 1));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test05SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaVerdaderoFalso(true);
        assertThrows(RespuestaNoCompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
