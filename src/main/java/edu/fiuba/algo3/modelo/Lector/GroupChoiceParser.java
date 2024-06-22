package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupChoiceParser implements Parser {

    private FabricaPreguntaGroupChoice fabrica;

    public GroupChoiceParser() {
        this.fabrica= new FabricaPreguntaGroupChoice();
    }

    private RespuestaGroupChoice getRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] grupos = respuestaCorrecta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        for (String grupo : grupos) {
            String[] claveValorGrupo = grupo.split(":");
            String clave = claveValorGrupo[0];
            String[] valores = claveValorGrupo[1].split(",");
            ArrayList<Integer> listaValor = new ArrayList<>();
            for (String valor : valores) {
                listaValor.add(Integer.parseInt(valor.trim()));
            }
            claveValor.put(clave, listaValor);
        }
        ArrayList<Integer> respuestaUno = claveValor.get("A");
        ArrayList<Integer> respuestaDos = claveValor.get("B");
        RespuestaGroupChoice respuesta = new RespuestaGroupChoice(respuestaUno, respuestaDos);
        return respuesta;
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

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        int idPregunta = jsonObject.get("ID").getAsInt();
        String tema = jsonObject.get("Tema").getAsString();
        String textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        String enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        ArrayList<String> opciones = getOpciones(jsonObject);
        RespuestaGroupChoice respuesta = getRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
