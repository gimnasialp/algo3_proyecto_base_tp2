package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoPoseeErroresException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public class LectorPreguntasJson {
    private HashMap<String, ParserRespuesta> parseadores;

    public LectorPreguntasJson(HashMap<String, ParserRespuesta> parseadores) {
        this.parseadores = parseadores;
    }

    public ArrayList<Pregunta> leerArchivo(JsonReader reader) {
        try {
            JsonElement preguntasJson = JsonParser.parseReader(reader);
            JsonArray jsonArray = preguntasJson.getAsJsonArray();
            return generarPreguntas(jsonArray);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public ArrayList<Pregunta> generarPreguntas(JsonArray jsonArray) throws ArchivoPoseeErroresException {
        ArrayList<Pregunta> preguntasTotales = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            JsonElement tipoPregunta = jsonElement.getAsJsonObject().get("Tipo");
            if(this.parseadores.containsKey(tipoPregunta.getAsString().toLowerCase())) {
                System.out.println("    ");
                System.out.println(jsonElement);
                try {
                    preguntasTotales.add(parse(jsonElement));
                } catch(RuntimeException ex) {
                    throw new ArchivoPoseeErroresException();
                }
            }
        }
        return preguntasTotales;
    }

    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        int idPregunta = jsonObject.get("ID").getAsInt();
        String tema = jsonObject.get("Tema").getAsString();
        String tipo = jsonObject.get("Tipo").getAsString().toLowerCase();
        String textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        String enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        ArrayList<String> opciones = getOpciones(jsonObject);
        ParserRespuesta tipoParseador = this.parseadores.get(tipo.toLowerCase());
        Respuesta respuesta = tipoParseador.parsearRespuesta(jsonObject);

        return new Pregunta(idPregunta, tema, tipo, enunciadoPregunta, opciones, textoRespuesta, respuesta);
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
}
