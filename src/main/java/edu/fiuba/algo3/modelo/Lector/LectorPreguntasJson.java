package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class LectorPreguntasJson implements Lector{
    private static final String rutaRelativa = "preguntas.json";
    private final ArrayList<Pregunta> preguntasTotales;

    public LectorPreguntasJson() {
        this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException {

        Parser parserVerdaderoFalsoClasico = new VerdaderoFalsoClasicoParser();
        Parser parserVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidadParser();
        //Parser parserMultipleChoice = new MultipleChoiceParser();
        //Parser parserOrden = new OrderParser();
        //Parser parserGrupo = new GroupChoiceParser();
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserMultipleChoice);
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserOrden);
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserGrupo);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserVerdaderoFalsoClasico);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserVerdaderoFalsoConPenalidad);
        return preguntasTotales;
    }

    private void agregarPreguntasDeArchivo(ArrayList<Pregunta> preguntasTotales, String ruta, Parser preguntaParser) throws ArchivoNoEncontradoException {

        JsonElement preguntasJson;
        JsonArray jsonarray;

        try {
            JsonReader reader = new JsonReader(new FileReader(ruta));
            preguntasJson = JsonParser.parseReader(reader);
            jsonarray = preguntasJson.getAsJsonArray();
            try{
                for (JsonElement jsonElement : jsonarray) {
                    if(jsonElement.getAsJsonObject().get("Tipo").getAsString().equals(preguntaParser.tipoPregunta())){
                        System.out.println("    ");
                        System.out.println(jsonElement);
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
