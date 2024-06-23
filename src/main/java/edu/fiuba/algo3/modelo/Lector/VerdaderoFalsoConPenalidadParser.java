package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidadParser extends Parser {

    private FabricaPreguntasVerdaderoFalsoConPenalidad fabrica;

    public VerdaderoFalsoConPenalidadParser() {
        fabrica = new FabricaPreguntasVerdaderoFalsoConPenalidad();
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
        return fabrica.crearPregunta(super.idPregunta,super.tema,super.enunciadoPregunta,respuesta,super.opciones,super.textoRespuesta);
    }

}
