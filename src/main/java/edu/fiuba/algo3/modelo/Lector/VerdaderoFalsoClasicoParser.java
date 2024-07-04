package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

public class VerdaderoFalsoClasicoParser extends Parser {

    private FabricaPreguntasVerdaderoFalso fabrica;

    public VerdaderoFalsoClasicoParser() {
        this.fabrica = new FabricaPreguntasVerdaderoFalso();
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
