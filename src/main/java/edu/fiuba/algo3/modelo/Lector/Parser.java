package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class Parser {

    public abstract Pregunta parse(JsonElement preguntaJson);

    public abstract String tipoPregunta();

}
