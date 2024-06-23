package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupChoiceParser extends Parser {

    private FabricaPreguntaGroupChoice fabrica;

    public GroupChoiceParser() {
        this.fabrica= new FabricaPreguntaGroupChoice();
    }

    @Override
    protected Respuesta obtenerRespuesta(JsonObject jsonObject){

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] grupos = respuestaCorrecta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        for (String grupo : grupos) {
            String[] claveValorGrupo = grupo.trim().split(":");
            String clave = claveValorGrupo[0];
            String[] valores = claveValorGrupo[1].trim().split(",");
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

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        RespuestaGroupChoice respuesta = (RespuestaGroupChoice) obtenerRespuesta(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta);
    }

}
