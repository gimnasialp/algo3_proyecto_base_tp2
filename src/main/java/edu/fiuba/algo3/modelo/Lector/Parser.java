package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public interface Parser {
    public Pregunta parse(JsonElement preguntaJson);

}
