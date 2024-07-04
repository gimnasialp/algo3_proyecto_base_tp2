package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ProveedorJsonPreguntas implements ProveedorPreguntas {
    HashMap<String, Parser> tiposPreguntas;

    public ProveedorJsonPreguntas(HashMap<String, Parser> tiposPreguntas) {
        this.tiposPreguntas = tiposPreguntas;
    }

    @Override
    public ArrayList<Pregunta> obtenerPreguntasDe(String nombreArchivo) throws ArchivoNoEncontradoException {
        try {
            JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
            LectorPreguntasJson lectorJson = new LectorPreguntasJson(this.tiposPreguntas);
            ArrayList<Pregunta> preguntas = lectorJson.leerArchivo(reader);
            return preguntas;
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException(e.toString());
        }
    }

    public void agregarTipoPregunta(HashMap<String, Parser> tipoPregunta) {
        this.tiposPreguntas.putAll(tipoPregunta);
    }

    public void quitarTipoPregunta(String tipoPregunta) {
        this.tiposPreguntas.remove(tipoPregunta);
    }

}