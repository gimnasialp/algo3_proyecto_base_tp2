package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class VerdaderoFalsoClasicoParser extends Parser{

    private FabricaPreguntasVerdaderoFalso fabrica;

    public VerdaderoFalsoClasicoParser() {
        this.fabrica= new FabricaPreguntasVerdaderoFalso();
        tipoPregunta = "verdadero falso simple";
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){

         opciones = new ArrayList<>();
        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(jsonObject.get("Respuesta").getAsInt());
        opciones.add(jsonObject.get("Opcion 1").getAsString());
        opciones.add(jsonObject.get("Opcion 2").getAsString());

        enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
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
