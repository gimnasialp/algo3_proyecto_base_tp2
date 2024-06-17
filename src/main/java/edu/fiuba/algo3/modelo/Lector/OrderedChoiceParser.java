package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;

import java.util.ArrayList;

public class OrderedChoiceParser implements Parser {

    private FabricaPreguntaOrderedChoice fabrica;

    public OrderedChoiceParser() {
        this.fabrica= new FabricaPreguntaOrderedChoice();
    }

    private RespuestaOrderedChoice getRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String elemento : lista) {
            listaRespuesta.add(Integer.getInteger(elemento));
        }
        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(listaRespuesta);

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
        RespuestaOrderedChoice respuesta = getRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);

    }

}
