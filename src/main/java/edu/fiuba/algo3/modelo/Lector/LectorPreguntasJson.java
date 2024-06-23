package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorPreguntasJson implements Lector{
    private static final String rutaRelativa = "preguntas.json";
    private final ArrayList<Pregunta> preguntasTotales;
    private HashMap<String, Parser> parseadores;

    public LectorPreguntasJson() {

        this.preguntasTotales = new ArrayList<>();
        this.parseadores = new HashMap<>();
        this.parseadores.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        this.parseadores.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        this.parseadores.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        this.parseadores.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        this.parseadores.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        this.parseadores.put("ordered choice", new OrderedChoiceParser());
        this.parseadores.put("group choice", new GroupChoiceParser());

    }

    private JsonArray leerArchivo() throws FileNotFoundException {
        JsonArray jsonarray;
        try {
            JsonReader reader = new JsonReader(new FileReader(rutaRelativa));
            JsonElement preguntasJson = JsonParser.parseReader(reader);
            jsonarray = preguntasJson.getAsJsonArray();

        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new RuntimeException(e.toString());
        }

        return jsonarray;
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() {
        JsonArray jsonarray = new JsonArray();
        try {
            jsonarray = leerArchivo();
        }catch (FileNotFoundException e){

        }
        try {
            for (JsonElement jsonElement : jsonarray) {
                String tipoPregunta = jsonElement.getAsJsonObject().get("Tipo").getAsString().toLowerCase();
                if (this.parseadores.containsKey(tipoPregunta)) {
                    this.preguntasTotales.add(this.parseadores.get(tipoPregunta).parse(jsonElement));
                }
            }

        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e.toString());
        } catch(CantidadErroneaDeRespuestasParaPreguntaException ex) {
            ex.printStackTrace();
        }

        return this.preguntasTotales;
    }

}
