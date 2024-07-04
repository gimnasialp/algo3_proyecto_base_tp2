package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoPoseeErroresException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public class LectorPreguntasJson {
    private HashMap<String, Parser> parseadores;

    public LectorPreguntasJson(HashMap<String, Parser> parseadores) {
        this.parseadores = parseadores;
    }

    public ArrayList<Pregunta> leerArchivo(JsonReader reader) throws RuntimeException {
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
            String nombreTipoPregunta = tipoPregunta.getAsString().toLowerCase();
            if (this.parseadores.containsKey(nombreTipoPregunta)) {
                try {
                    preguntasTotales.add(this.parseadores.get(nombreTipoPregunta).parse(jsonElement));
                } catch (RuntimeException ex) {
                    throw new ArchivoPoseeErroresException();
                }
            }
        }
        return preguntasTotales;
    }

}
