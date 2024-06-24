package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;

public class MultipleChoicePenalidadParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoicePenalidadParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaMultipleChoiceConPenalidad parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaMultipleChoiceConPenalidad(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
