package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

public class MultipleChoiceParcialParser extends Parser {

    private FabricaPreguntaMultipleChoiceParcial fabrica;

    public MultipleChoiceParcialParser() {
        this.fabrica = new FabricaPreguntaMultipleChoiceParcial();
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
