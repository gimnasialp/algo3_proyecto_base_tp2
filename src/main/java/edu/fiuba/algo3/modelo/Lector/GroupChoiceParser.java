package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;

public class GroupChoiceParser extends Parser {

    private FabricaPreguntaGroupChoice fabrica;
    private ArrayList<String> grupos;

    public GroupChoiceParser() {
        this.fabrica = new FabricaPreguntaGroupChoice();
    }

    private void obtenerGrupos(JsonObject jsonObject) {
        this.grupos = new ArrayList<>();
        this.grupos.add(jsonObject.get("Grupo A").getAsString());
        this.grupos.add(jsonObject.get("Grupo B").getAsString());
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        JsonObject jsonObject = preguntaJson.getAsJsonObject();
        obtenerDatosDePregunta(jsonObject);
        obtenerGrupos(jsonObject);

        return fabrica.crearPregunta(idPregunta, tema, enunciadoPregunta, respuesta, opciones, textoRespuesta, grupos);
    }

}
