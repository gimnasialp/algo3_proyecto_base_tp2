package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorPreguntasJson implements Lector{

    private static final String rutaRelativa = "preguntas.json";
    private final ArrayList<Pregunta> preguntasTotales;

    public LectorPreguntasJson() {
        this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException {
        List<Parser> parsers = List.of(
                new VerdaderoFalsoClasicoParser(),
                new VerdaderoFalsoConPenalidadParser(),
                new MultipleChoiceClasicoParser(),
                new MultipleChoicePenalidadParser(),
                new MultipleChoiceParcialParser(),
                new OrderedChoiceParser(),
                new GroupChoiceParser()
        );
        for (Parser parser : parsers) {
            agregarPreguntas(preguntasTotales, parser);
        }
        return preguntasTotales;
    }

    private void agregarPreguntas(ArrayList<Pregunta> preguntasTotales, Parser preguntaParser) throws ArchivoNoEncontradoException {

        JsonElement preguntasJson;
        JsonArray jsonarray;

        try {
            JsonReader reader = new JsonReader(new FileReader(rutaRelativa));
            preguntasJson = JsonParser.parseReader(reader);
            jsonarray = preguntasJson.getAsJsonArray();
            try{
                for (JsonElement jsonElement : jsonarray) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    String tipo = jsonObject.get("Tipo").getAsString().toLowerCase();

                    if (tipo.equals(preguntaParser.tipoPregunta().toLowerCase())) {
                        preguntasTotales.add(preguntaParser.parse(jsonElement));
                    }
                }
            } catch (JsonSyntaxException e) {
                throw new RuntimeException(e.toString());
            }catch(CantidadErroneaDeRespuestasParaPreguntaException ex) {
                ex.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.toString());
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e.toString());
        }

    }

}
