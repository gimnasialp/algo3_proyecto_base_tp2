package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorPreguntasJson implements Lector{
    private static final String rutaRelativa = "./ArchivosPreguntas/preguntas.json";
    private final ArrayList<Pregunta> preguntasTotales;

    public LectorPreguntasJson() {
        this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException {

        Parser parserVerdaderoFalsoClasico = new VerdaderoFalsoClasicoParser();
        Parser parserVerdaderoFalsoConPenalidad = new VerdaderoFalsoConPenalidadParser();
        Parser parserMultipleChoice = new MultipleChoiceParser();
        Parser parserOrden = new OrderParser();
        Parser parserGrupo = new GroupChoiceParser();
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserMultipleChoice);
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserOrden);
        //agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserGrupo);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserVerdaderoFalsoClasico);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserVerdaderoFalsoConPenalidad);
        return preguntasTotales;
    }

    private void agregarPreguntasDeArchivo(ArrayList<Pregunta> preguntasTotales, String ruta, Parser preguntaParser) throws ArchivoNoEncontradoException {

        JsonElement preguntasJson;
        JsonArray jsonarray = new JsonArray();

        try {
            JsonReader reader = new JsonReader(new FileReader(rutaRelativa));
            preguntasJson = JsonParser.parseReader(reader);
            jsonarray = preguntasJson.getAsJsonArray();

            for (JsonElement jsonElement : jsonarray) {
                String elemento = jsonElement.getAsJsonObject().get("Tipo").getAsString();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.toString());
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e.toString());
        }
    }

/*
    private void agregarPreguntas(ArrayList<Pregunta> preguntasTotales, FileReader lector, Parser preguntaParser, JSONParser jsonParser) throws IOException, ParseException {

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        Object obj = jsonParser.parse(lector);
        JSONArray preguntasJson = (JSONArray) obj;

        for(Object jsPregunta : preguntasJson){
            try{
                Pregunta unaPregunta = preguntaParser.parse((JSONObject) jsPregunta);
                preguntas.add(unaPregunta);
            } catch(CantidadErroneaDeRespuestasParaPreguntaException ex){
                ex.printStackTrace();
            }
        }

        preguntasTotales.addAll(preguntas);
    }*/
}
