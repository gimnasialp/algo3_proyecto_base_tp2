package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;

public class GroupChoiceParser implements ParserRespuesta {
    private ParserGruposRespuesta parserRespuesta;

    public GroupChoiceParser() {
        this.parserRespuesta = new ParserGruposRespuesta();
    }

    public ArrayList<String> getGrupos(JsonObject jsonObject) {
        ArrayList<String> grupos = new ArrayList<>();
        grupos.add(jsonObject.get("Grupo A").getAsString());
        grupos.add(jsonObject.get("Grupo B").getAsString());

        return grupos;
    }

    public RespuestaGroupChoice parsearRespuesta(JsonObject jsonObject) {
        String respuesta = jsonObject.get("Respuesta").getAsString();
        ArrayList<String> grupos = getGrupos(jsonObject);
        RespuestaGroupChoice respuestaGroupChoice = new RespuestaGroupChoice(this.parserRespuesta.parsearGruposRespuesta(respuesta, grupos));
        respuestaGroupChoice.setGrupos(grupos);
        return respuestaGroupChoice;
    }
}
