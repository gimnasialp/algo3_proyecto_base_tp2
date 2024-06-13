package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

public class GroupChoiceParser implements Parser {

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        return null;
    }

    @Override
    public String tipoPregunta() {
        return "";
    }
}
