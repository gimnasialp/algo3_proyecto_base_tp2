package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.ObtenedorPreguntaSiguienteSegunTema;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ObtenedorPreguntaSiguienteSegunTemaTest {

    @Test
    public void testLasPreguntasObtenidasDesdeElObtenedorSonAleatorias() {
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

        ObtenedorPreguntaSiguienteSegunTema obtenedorPreguntaUno = new ObtenedorPreguntaSiguienteSegunTema(preguntasLector);

        Pregunta preguntaUnoConObtenedorUno = obtenedorPreguntaUno.obtenerPreguntaSiguiente();
        Pregunta preguntaDosConObtenedorUno = obtenedorPreguntaUno.obtenerPreguntaSiguiente();
        ArrayList<Pregunta> preguntasConObtenedorUno = new ArrayList<>(Arrays.asList(preguntaUnoConObtenedorUno, preguntaDosConObtenedorUno));

        ObtenedorPreguntaSiguienteSegunTema obtenedorPreguntaDos = new ObtenedorPreguntaSiguienteSegunTema(preguntasLector);

        Pregunta preguntaUnoConObtenedorDos = obtenedorPreguntaDos.obtenerPreguntaSiguiente();
        Pregunta preguntaDosConObtenedorDos = obtenedorPreguntaDos.obtenerPreguntaSiguiente();
        ArrayList<Pregunta> preguntasConObtenedorDos = new ArrayList<>(Arrays.asList(preguntaUnoConObtenedorDos, preguntaDosConObtenedorDos));

        assertNotEquals(preguntasConObtenedorUno, preguntasConObtenedorDos);
    }

    @Test
    public void testCincoPreguntasConsecutivasSonDeDistintoTipo() {
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);

        ArrayList<Pregunta> preguntasLector = proveedor.obtenerPreguntasDe("preguntas.json");

        ObtenedorPreguntaSiguienteSegunTema obtenedorPregunta = new ObtenedorPreguntaSiguienteSegunTema(preguntasLector);

        String tipoPreguntaUno = obtenedorPregunta.obtenerPreguntaSiguiente().obtenerTema();
        String tipoPreguntaDos = obtenedorPregunta.obtenerPreguntaSiguiente().obtenerTema();
        String tipoPreguntaTres = obtenedorPregunta.obtenerPreguntaSiguiente().obtenerTema();
        String tipoPreguntaCuatro = obtenedorPregunta.obtenerPreguntaSiguiente().obtenerTema();
        String tipoPreguntaCinco = obtenedorPregunta.obtenerPreguntaSiguiente().obtenerTema();
        System.out.println(tipoPreguntaUno);
        System.out.println(tipoPreguntaDos);
        System.out.println(tipoPreguntaTres);
        System.out.println(tipoPreguntaCuatro);
        System.out.println(tipoPreguntaCinco);

        assertNotEquals(tipoPreguntaUno, tipoPreguntaDos);
        assertNotEquals(tipoPreguntaDos, tipoPreguntaTres);
        assertNotEquals(tipoPreguntaTres, tipoPreguntaCuatro);
        assertNotEquals(tipoPreguntaCuatro, tipoPreguntaCinco);
    }
}