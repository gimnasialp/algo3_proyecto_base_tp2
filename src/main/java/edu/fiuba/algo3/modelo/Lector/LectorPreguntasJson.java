package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class LectorPreguntasJson implements Lector{
    private static final String rutaRelativa = "./ArchivosPreguntas/preguntas.json";
    private final ArrayList<Pregunta> preguntasTotales;

    public LectorPreguntasJson() {
        this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException {

        Parser parserVerdaderoFalso = new VerdaderoFalsoParser();
        Parser parserMultipleChoice = new MultipleChoiceParser();
        Parser parserOrden = new OrderParser();
        Parser parserGrupo = new GroupChoiceParser();
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserMultipleChoice);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserOrden);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserGrupo);
        agregarPreguntasDeArchivo(preguntasTotales, rutaRelativa, parserVerdaderoFalso);
        return preguntasTotales;
    }

    private void agregarPreguntasDeArchivo(ArrayList<Pregunta> preguntasTotales, String ruta, Parser preguntaParser) throws ArchivoNoEncontradoException {

        JSONParser jsonParser = new JSONParser();

        try (FileReader lector = new FileReader(System.getProperty("user.dir") + ruta)) {

            agregarPreguntas(preguntasTotales, lector, preguntaParser, jsonParser);

        } catch (FileNotFoundException ex) {
            throw new ArchivoNoEncontradoException(System.getProperty("user.dir") + ruta);

        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }


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
    }
}
