package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceEspecial;

import java.util.ArrayList;

public class MultipleChoiceParcialParser implements Parser {

    private FabricaPreguntaMultipleChoiceParcial fabrica;
    private int idPregunta;
    private String tema;
    private String tipoPregunta;
    private String textoRespuesta;
    private ArrayList<String> opciones = new ArrayList<>();
    private String enunciadoPregunta;

    public MultipleChoiceParcialParser() {
        this.fabrica= new FabricaPreguntaMultipleChoiceParcial();
        tipoPregunta = "multiple choice puntaje parcial";
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        ArrayList<String> opciones = new ArrayList<>();
        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String elemento : lista) {
            listaRespuesta.add(Integer.parseInt(elemento));
        }
        RespuestaMultipleChoiceEspecial respuesta = new RespuestaMultipleChoiceEspecial(listaRespuesta);
        respuestas.add(respuesta);
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
