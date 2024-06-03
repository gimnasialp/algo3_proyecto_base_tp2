package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.tp2.modelo.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2.modelo.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {



    private String enunciado;
    private List<String> opciones;
    private Set<Integer> opcionesCorrectas;
    private PreguntaMultipleChoice preguntaMC;

    public PreguntaMultipleChoiceTest() {
        this.enunciado = "Versiones java existentes son";
        this.opciones = Arrays.asList("17", "11", "8", "fruta", "verdura");
        this.opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2));
    }

    private void crearMultipleChoiceClasico() {
        this.preguntaMC = PreguntaMultipleChoice.Clasico(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    private void crearMultipleChoiceParcial() {
        this.preguntaMC = PreguntaMultipleChoice.Parcial(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    private void crearMultipleChoicePenalidad() {
        this.preguntaMC = PreguntaMultipleChoice.Penalidad(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    /* Clasico */
    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(this.opcionesCorrectas);
        assertEquals(Collections.singletonList(1), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 3)));
        assertEquals(Arrays.asList(1, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiSeRespondeIncorrectamente(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 3)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoSeEnviaLaTotalidadDeRespuestasCorrectas(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 0)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    /* Parcial */
    @Test
    public void MultipleChoiceParcialPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 1, 3)));
        assertEquals(Arrays.asList(3, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1, 3)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    /* Penalidad */
    @Test
    public void MultipleChoicePenalidadPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoicePenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 4, 1)));
        assertEquals(Arrays.asList(3, 1), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }


    @Test
    public void MultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1, 4)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve0SiNoEnvioNada(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelveMenos1SiEnvioRespuestaIncorrecta(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4)));
        assertEquals(Collections.singletonList(-1), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

}
