package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupChoiceParser extends Parser {

    private FabricaPreguntaGroupChoice fabrica;

    public GroupChoiceParser() {
        this.fabrica = new FabricaPreguntaGroupChoice();
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
