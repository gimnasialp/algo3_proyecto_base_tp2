package edu.fiuba.algo3.entrega_2.Respuesta;

import edu.fiuba.algo3.tp2.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RespuestaMultipleChoiceTest {


    private RespuestaMultipleChoice respuestaCorrecta;

    public void setupRespuestaCorrectaClasico() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(4, 5, 2));
        this.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, PuntajeClasico.ParaMultipleChoice(opcionesCorrectas));
    }

    public void setupRespuestaCorrectaParcial() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(4, 5, 2));
        this.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajeParcial());
    }

    public void setupRespuestaCorrectaPenalidad() {
        Set<Integer> opcionesCorrectas = new HashSet<>(Arrays.asList(4, 5, 2));
        this.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajePenalidad());
    }

    @Test
    public void test01LaInterseccionEntreDosRespuestasMultipleChoiceEsLaInterseccionEntreSusOpciones() {
        setupRespuestaCorrectaClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 4)));
        assertEquals(new HashSet<>(Arrays.asList(2, 4)), respuestaCorrecta.intersection(respuesta));
    }

    @Test
    public void test02ElTamanioDeUnaRespuestaMultipleChoiceEsElDeSusOpciones() {
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 4)));
        assertEquals(3, respuesta.size());
    }

    @Test
    public void test03UnaRespuestaMultipleChoiceClasicoCorrectaValeUnPunto() {
        setupRespuestaCorrectaClasico();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2, 5)));
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04UnaRespuestaMultipleChoiceClasicoIncorrectaValeCeroPuntos() {
        setupRespuestaCorrectaClasico();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2, 3, 5)));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test05UnaRespuestaMultipleChoiceClasicoIncompletaValeCeroPuntos() {
        setupRespuestaCorrectaClasico();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 5)));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test06UnaRespuestaMultipleChoiceParcialVale2ConDosRespuestasCorrectas() {
        setupRespuestaCorrectaParcial();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 5)));
        assertEquals(2, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test07UnaRespuestaMultipleChoiceParcialVale0ConTresRespuestasCorrectasYUnaIncorrecta() {
        setupRespuestaCorrectaParcial();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2, 5, 3)));
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test08UnaRespuestaMultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas() {
        setupRespuestaCorrectaPenalidad();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2)));
        assertEquals(2, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test09UnaRespuestaMultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta() {
        setupRespuestaCorrectaPenalidad();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 2, 5, 1)));
        assertEquals(2, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test10UnaRespuestaMultipleChoicePenalidadRestaDosPuntosSiEnvioDosRespuestasIncorrectas() {
        setupRespuestaCorrectaPenalidad();
        Respuesta respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(3, 1)));
        assertEquals(-2, respuestaCorrecta.evaluar(respuesta));
    }


    @Test
    public void test11SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrectaClasico();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(1, 2, 3));
        assertThrows(RespuestaNoCompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
