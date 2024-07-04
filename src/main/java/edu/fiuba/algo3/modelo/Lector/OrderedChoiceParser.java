package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;


public class OrderedChoiceParser extends Parser {

    private FabricaPreguntaOrderedChoice fabrica;

    public OrderedChoiceParser() {
        this.fabrica = new FabricaPreguntaOrderedChoice();
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }


}
