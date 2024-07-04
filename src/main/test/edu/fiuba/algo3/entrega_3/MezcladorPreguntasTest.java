package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.MezcladorPreguntasSegunTema;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MezcladorPreguntasTest {
    private ArrayList<Pregunta> preguntas;

    @BeforeEach
    public void setUpPreguntas() {
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());
        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        this.preguntas = proveedor.obtenerPreguntasDe("preguntas.json");
    }

    @Test
    public void testDosPreguntasConsecutivasTienenDistintoTema() {
        MezcladorPreguntasSegunTema mezclador = new MezcladorPreguntasSegunTema(this.preguntas);
        ArrayList<Pregunta> preguntasMezcladas = mezclador.mezclarPreguntas();

        String temaPreguntaUno = preguntasMezcladas.get(0).obtenerTema();
        String temaPreguntaDos = preguntasMezcladas.get(1).obtenerTema();
        String temaPreguntaTres = preguntasMezcladas.get(2).obtenerTema();
        String temaPreguntaCuatro = preguntasMezcladas.get(3).obtenerTema();
        String temaPreguntaCinco = preguntasMezcladas.get(4).obtenerTema();

        assertNotEquals(temaPreguntaUno, temaPreguntaDos);
        assertNotEquals(temaPreguntaDos, temaPreguntaTres);
        assertNotEquals(temaPreguntaTres, temaPreguntaCuatro);
        assertNotEquals(temaPreguntaCuatro, temaPreguntaCinco);
    }

    @Test
    public void testDeCuatroPreguntasTresSonDelMismoTemaEntoncesLasUltimasDosPreguntasSonDelMismoTema() {
        ArrayList<Pregunta> cuatroPreguntas = new ArrayList<>();
        //Hay 1 pregunta de arte y 3 de ciencias
        cuatroPreguntas.addAll(this.preguntas.subList(0, 4));
        MezcladorPreguntasSegunTema mezclador = new MezcladorPreguntasSegunTema(cuatroPreguntas);
        ArrayList<Pregunta> preguntasMezcladas = mezclador.mezclarPreguntas();

        String temaPreguntaUno = preguntasMezcladas.get(0).obtenerTema();
        String temaPreguntaDos = preguntasMezcladas.get(1).obtenerTema();
        String temaPreguntaTres = preguntasMezcladas.get(2).obtenerTema();
        String temaPreguntaCuatro = preguntasMezcladas.get(3).obtenerTema();

        assertNotEquals(temaPreguntaUno, temaPreguntaDos);
        assertEquals(temaPreguntaTres, temaPreguntaCuatro);
    }

}