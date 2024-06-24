package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ProveedorJsonPreguntas implements ProveedorPreguntas {
    HashMap<String, ParserRespuesta> tiposPreguntas;

    public ProveedorJsonPreguntas(HashMap<String, ParserRespuesta> tiposPreguntas) {
        this.tiposPreguntas = tiposPreguntas;
        /*this.tiposPreguntas = new HashMap<>();
        this.tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        this.tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        this.tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        this.tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        this.tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        this.tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        this.tiposPreguntas.put("group choice", new GroupChoiceParser());*/
    }

    @Override
    public ArrayList<Pregunta> obtenerPreguntasDe(String nombreArchivo) throws ArchivoNoEncontradoException {
        try {
            JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
            LectorPreguntasJson lectorJson = new LectorPreguntasJson(this.tiposPreguntas);
            ArrayList<Pregunta> preguntas = lectorJson.leerArchivo(reader);
            return preguntas;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public void agregarTipoPregunta(HashMap<String, ParserRespuesta> tipoPregunta) {
        this.tiposPreguntas.putAll(tipoPregunta);
    }

    public void quitarTipoPregunta(String tipoPregunta) {
        this.tiposPreguntas.remove(tipoPregunta);
    }

}