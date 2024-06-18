package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class GroupChoiceParser implements Parser {

    private FabricaPreguntaGroupChoice fabrica;
    private int idPregunta;
    private String tema;
    private String tipoPregunta;
    private String textoRespuesta;
    private ArrayList<String> opciones = new ArrayList<>();
    private String enunciadoPregunta;

    public GroupChoiceParser() {
        this.fabrica= new FabricaPreguntaGroupChoice();
        tipoPregunta = "group choice";
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        ArrayList<String> opciones = new ArrayList<>();
        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();

        String respuestaCorrecta = jsonObject.get("Respuesta").getAsString();
        String[] grupos = respuestaCorrecta.split(";");
        HashMap<String, ArrayList<Integer>> claveValor = new HashMap<>();
        for (String grupo : grupos) {
            String[] claveValorGrupo = grupo.trim().split(":");
            String clave = claveValorGrupo[0];
            String[] valores = claveValorGrupo[1].trim().split(",");
            ArrayList<Integer> listaValor = new ArrayList<>();
            for (String valor : valores) {
                listaValor.add(Integer.parseInt(valor));
            }
            claveValor.put(clave, listaValor);
        }
        ArrayList<Integer> respuestaUno = claveValor.get("A");
        ArrayList<Integer> respuestaDos = claveValor.get("B");

        RespuestaGroupChoice respuesta = new RespuestaGroupChoice(respuestaUno, respuestaDos);
        respuestas.add(respuesta);

        int numeroOpcion = 1;
        String claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        while (jsonObject.keySet().contains(claveOpcion)) {
            opciones.add(jsonObject.get(claveOpcion).getAsString());
            numeroOpcion++;
            claveOpcion = "Opcion ".concat(Integer.toString(numeroOpcion));
        }

        enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        Pregunta pregunta = fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta,opciones, textoRespuesta);
        return pregunta;

    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        return OrganizarDatos(preguntaJson.getAsJsonObject());
    }

    @Override
    public String tipoPregunta() {
        return tipoPregunta;
    }

}
