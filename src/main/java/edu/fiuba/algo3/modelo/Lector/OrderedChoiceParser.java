package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;

public class OrderedChoiceParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public OrderedChoiceParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaOrderedChoice parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaOrderedChoice(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
