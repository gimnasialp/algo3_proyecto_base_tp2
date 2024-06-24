package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPuntajeParcial;

public class MultipleChoiceParcialParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoiceParcialParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public Respuesta parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaMultipleChoiceConPuntajeParcial(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
