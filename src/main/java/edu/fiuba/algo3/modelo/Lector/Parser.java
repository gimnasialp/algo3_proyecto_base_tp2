package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;

public abstract class Parser {
    protected int idPregunta;
    protected String tema;
    protected String tipoPregunta;
    protected String textoRespuesta;
    protected ArrayList<String> opciones = new ArrayList<>();
    protected String enunciadoPregunta;

    public abstract Pregunta parse(JsonElement preguntaJson);

    public abstract String tipoPregunta();

}
