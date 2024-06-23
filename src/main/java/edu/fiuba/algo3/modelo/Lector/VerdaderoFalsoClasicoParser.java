package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class VerdaderoFalsoClasicoParser extends Parser {

    private FabricaPreguntasVerdaderoFalso fabrica;

    public VerdaderoFalsoClasicoParser() {
        this.fabrica= new FabricaPreguntasVerdaderoFalso();
    }

    @Override
    protected Respuesta obtenerRespuesta(JsonObject jsonObject) {
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(jsonObject.get("Respuesta").getAsInt());
        return respuesta;

    }


    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        RespuestaVerdaderoFalso respuesta = (RespuestaVerdaderoFalso) obtenerRespuesta(jsonObject);
        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
