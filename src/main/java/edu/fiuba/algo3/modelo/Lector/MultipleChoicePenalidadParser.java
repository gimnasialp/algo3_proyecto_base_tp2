package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceEspecial;

import java.util.ArrayList;

public class MultipleChoicePenalidadParser implements Parser {
    private FabricaPreguntaMultipleChoiceConPenalidad fabrica;

    public MultipleChoicePenalidadParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceConPenalidad();
    }

    private RespuestaMultipleChoiceEspecial getRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String elemento : lista) {
            listaRespuesta.add(Integer.getInteger(elemento));
        }
        RespuestaMultipleChoiceEspecial respuesta = new RespuestaMultipleChoiceEspecial(listaRespuesta);

        return respuesta;
    }

    public ArrayList<String> getOpciones(JsonObject jsonObject) {
        ArrayList<String> opciones = new ArrayList<>();
        int numeroOpcion = 1;
        String claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        while  (jsonObject.keySet().contains(claveOpcion)) {
            opciones.add(jsonObject.get(claveOpcion).getAsString());
            numeroOpcion++;
            claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        }

        return opciones;
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        int idPregunta = jsonObject.get("ID").getAsInt();
        String tema = jsonObject.get("Tema").getAsString();
        String textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        String enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        ArrayList<String> opciones = getOpciones(jsonObject);
        RespuestaMultipleChoiceEspecial respuesta = getRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }

}
