package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;


import java.util.ArrayList;

public class MultipleChoiceCLasicoParser extends Parser {
    private FabricaPreguntaMultipleChoiceClasico fabrica;

    public MultipleChoiceCLasicoParser() {
        this.fabrica = new FabricaPreguntaMultipleChoiceClasico();
    }

    @Override
    protected Respuesta obtenerRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceClasico respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);

        return respuesta;
    }


    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        RespuestaMultipleChoiceClasico respuesta = (RespuestaMultipleChoiceClasico) obtenerRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
