package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

public class VerdaderoFalsoConPenalidadParser extends Parser {

    private FabricaPreguntasVerdaderoFalsoConPenalidad fabrica;

    public VerdaderoFalsoConPenalidadParser() {
        fabrica = new FabricaPreguntasVerdaderoFalsoConPenalidad();
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        return fabrica.crearPregunta(idPregunta,tema,enunciadoPregunta,respuesta,opciones,textoRespuesta);
    }

}
