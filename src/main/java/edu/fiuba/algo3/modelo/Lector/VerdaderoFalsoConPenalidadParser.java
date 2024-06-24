package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoConPenalidad;

public class VerdaderoFalsoConPenalidadParser implements ParserRespuesta {
    private ParserRespuestaUnica parserRespuesta;

    public VerdaderoFalsoConPenalidadParser() {
        this.parserRespuesta = new ParserRespuestaUnica();
    }

    public RespuestaVerdaderoFalsoConPenalidad parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        return new RespuestaVerdaderoFalsoConPenalidad(this.parserRespuesta.parsearOpcionRespuesta(respuesta));
    }
}
