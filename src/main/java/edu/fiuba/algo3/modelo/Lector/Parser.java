package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;


import java.util.ArrayList;

public abstract class Parser {

    protected int idPregunta;
    protected String tema;
    protected String textoRespuesta;
    protected String enunciadoPregunta;
    protected ArrayList<String> opciones;
    protected String respuesta;

    public abstract Pregunta parse(JsonElement preguntaJson);

    protected ArrayList<String> obtenerOpciones(JsonObject jsonObject) {

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

    protected void obtenerDatosDePregunta(JsonObject jsonObject) {
        this.idPregunta = jsonObject.get("ID").getAsInt();
        this.tema = jsonObject.get("Tema").getAsString();
        this.textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        this.enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        this.opciones = obtenerOpciones(jsonObject);
        this.respuesta = jsonObject.get("Respuesta").getAsString();
    }
}
