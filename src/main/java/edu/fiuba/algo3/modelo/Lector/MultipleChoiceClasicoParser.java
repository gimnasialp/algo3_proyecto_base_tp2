package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;

import java.util.ArrayList;

public class MultipleChoiceClasicoParser extends Parser {
    private FabricaPreguntaMultipleChoiceClasico fabrica;

    public MultipleChoiceClasicoParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceClasico();
        tipoPregunta = "multiple choice simple";
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){

        opciones = new ArrayList<>();
        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String elemento : lista) {
            listaRespuesta.add(Integer.getInteger(elemento));
        }
        RespuestaMultipleChoiceClasico respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);
        int numeroOpcion = 1;
        String claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        while  (jsonObject.keySet().contains(claveOpcion)) {
            opciones.add(jsonObject.get(claveOpcion).getAsString());
            numeroOpcion++;
            claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        }

        enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        Pregunta pregunta = fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta,opciones, textoRespuesta);
        return pregunta;

    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        return OrganizarDatos(preguntaJson.getAsJsonObject());
    }

    @Override
    public String tipoPregunta() {
        return tipoPregunta;
    }
}
