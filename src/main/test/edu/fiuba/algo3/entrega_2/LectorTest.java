package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LectorTest {

    @Test
    public void ProveedorJsonPreguntasMeGeneraTodasLasPreguntasDeUnArchivoDelTipoQueLePido() {
        HashMap<String, ParserRespuesta> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");

        assertEquals(9, preguntas.size());
    }

    @Test
    public void lectorMeGenera25objetosDeTipoPregunta() {

        HashMap<String, ParserRespuesta> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");

        assertEquals(25, preguntas.size());
    }

    @Test
    public void lectorDevuelveExcepcionCuandoSeLePasoUnArchivoInexistente() {
        HashMap<String, ParserRespuesta> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        assertThrows(ArchivoNoEncontradoException.class, () -> {
            proveedor.obtenerPreguntasDe("nombreInexistente.json");
        });
    }

}
