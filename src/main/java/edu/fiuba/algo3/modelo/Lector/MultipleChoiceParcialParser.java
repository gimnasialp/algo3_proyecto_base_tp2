package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;


import java.util.ArrayList;

public class MultipleChoiceParcialParser extends Parser {

    private FabricaPreguntaMultipleChoiceParcial fabrica;

    public MultipleChoiceParcialParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceParcial();
    }

    @Override
    protected Respuesta obtenerRespuesta(JsonObject jsonObject){

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
        obtenerDatosDePregunta(jsonObject);
        RespuestaMultipleChoiceParcial respuesta = (RespuestaMultipleChoiceParcial) obtenerRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }

}
