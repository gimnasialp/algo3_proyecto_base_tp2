package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;


public class MultipleChoiceCLasicoParser extends Parser {

    private FabricaPreguntaMultipleChoiceClasico fabrica;

    public MultipleChoiceCLasicoParser() {
        this.fabrica = new FabricaPreguntaMultipleChoiceClasico();
    }


    @Override
    public Pregunta parse(JsonElement preguntaJson) {

        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
