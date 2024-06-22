package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidadParser extends Parser {

    private FabricaPreguntasVerdaderoFalsoConPenalidad fabrica;

    public VerdaderoFalsoConPenalidadParser() {
        fabrica = new FabricaPreguntasVerdaderoFalsoConPenalidad();
    }

    private RespuestaVerdaderoFalso getRespuesta(JsonObject jsonObject) {

        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(jsonObject.get("Respuesta").getAsInt());

        return respuesta;

    }


    @Override
    public Pregunta parse(JsonElement preguntaJson) {

        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        int idPregunta = jsonObject.get("ID").getAsInt();
        String tema = jsonObject.get("Tema").getAsString();
        String textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        String enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        ArrayList<String> opciones = getOpciones(jsonObject);
        RespuestaVerdaderoFalso respuesta = getRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
