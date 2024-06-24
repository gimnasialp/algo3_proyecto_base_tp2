package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceComun;

public class MultipleChoiceCLasicoParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoiceCLasicoParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaMultipleChoiceComun parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaMultipleChoiceComun(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
