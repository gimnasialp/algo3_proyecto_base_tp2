package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoClasico;

public class VerdaderoFalsoClasicoParser implements ParserRespuesta {
    private ParserRespuestaUnica parserRespuesta;

    public VerdaderoFalsoClasicoParser() {
        this.parserRespuesta = new ParserRespuestaUnica();
    }

    public RespuestaVerdaderoFalsoClasico parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaVerdaderoFalsoClasico(this.parserRespuesta.parsearOpcionRespuesta(respuesta));
    }
}
