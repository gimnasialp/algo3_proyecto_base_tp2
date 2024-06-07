package edu.fiuba.algo3.entrega_2.Respuesta;

import edu.fiuba.algo3.tp2.modelo.Respuesta;
import edu.fiuba.algo3.tp2.modelo.RespuestaGroupChoice;
import edu.fiuba.algo3.tp2.modelo.RespuestaNoCompatibleException;
import edu.fiuba.algo3.tp2.modelo.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaGroupChoiceTest {

    private RespuestaGroupChoice respuestaCorrecta;

    public void setupRespuestaCorrecta() {
        Set<Integer> grupoA = new HashSet<>(Arrays.asList(4, 1, 3));
        Set<Integer> grupoB = new HashSet<>(Arrays.asList(6, 2, 5));

        this.respuestaCorrecta = new RespuestaGroupChoice(grupoA, grupoB);
    }

    @Test
    public void test01DosRespuestasGroupChoiceSonIgualesSiAmbastienenLosMismosGrupos() {
        setupRespuestaCorrecta();
        Set<Integer> grupoA = new HashSet<>(Arrays.asList(4, 1, 3));
        Set<Integer> grupoB = new HashSet<>(Arrays.asList(6, 2, 5));

        RespuestaGroupChoice respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        assertTrue(respuestaCorrecta.equals(respuesta));
    }

    @Test
    public void test02UnaRespuestaGroupChoiceCorrectaValeUnPunto() {
        setupRespuestaCorrecta();
        Set<Integer> grupoA = new HashSet<>(Arrays.asList(4, 1, 3));
        Set<Integer> grupoB = new HashSet<>(Arrays.asList(6, 2, 5));

        Respuesta respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test03UnaRespuestaGroupChoiceIncorrectaValeCeroPuntos() {
        setupRespuestaCorrecta();
        Set<Integer> grupoA = new HashSet<>(Arrays.asList(4, 3));
        Set<Integer> grupoB = new HashSet<>(Arrays.asList(6, 1, 2, 5));

        Respuesta respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04UnaPreguntaGCValeCeroSiNoSeSeleccionanTodosLosElementos() {
        setupRespuestaCorrecta();
        Set<Integer> grupoA = new HashSet<>(Arrays.asList(4, 1, 3));
        Set<Integer> grupoB = new HashSet<>(Arrays.asList(6, 5));

        Respuesta respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }


    @Test
    public void test05SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaVerdaderoFalso(true);
        assertThrows(RespuestaNoCompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
