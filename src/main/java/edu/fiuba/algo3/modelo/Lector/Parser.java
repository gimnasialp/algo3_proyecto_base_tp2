package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.json.simple.JSONObject;

public interface Parser {
    public Pregunta parse(JSONObject jsPregunta);
}
