package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;


import java.util.ArrayList;

public class MultipleChoiceParcialParser extends Parser {

    private FabricaPreguntaMultipleChoiceParcial fabrica;

    public MultipleChoiceParcialParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceParcial();
    }

    private RespuestaMultipleChoiceParcial getRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(listaRespuesta);

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
        RespuestaMultipleChoiceParcial respuesta = getRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }

}
