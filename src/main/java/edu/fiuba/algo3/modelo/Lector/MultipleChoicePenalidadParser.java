package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;

import java.util.ArrayList;

public class MultipleChoicePenalidadParser extends Parser {
    private FabricaPreguntaMultipleChoiceConPenalidad fabrica;

    public MultipleChoicePenalidadParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceConPenalidad();
    }

    @Override
    protected Respuesta obtenerRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceConPenalidad respuesta = new RespuestaMultipleChoiceConPenalidad(listaRespuesta);

        return respuesta;
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        RespuestaMultipleChoiceConPenalidad respuesta = (RespuestaMultipleChoiceConPenalidad) obtenerRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }

}
