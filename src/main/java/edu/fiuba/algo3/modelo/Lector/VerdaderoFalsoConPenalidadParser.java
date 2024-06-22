package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Fabricas.FabricaPreguntasVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class VerdaderoFalsoConPenalidadParser extends   Parser{

    private FabricaPreguntasVerdaderoFalsoConPenalidad fabrica;
    private int idPregunta;
    private String tema;
    private String tipoPregunta;
    private String textoRespuesta;
    private ArrayList<String> opciones = new ArrayList<>();
    private String enunciadoPregunta;

    public VerdaderoFalsoConPenalidadParser() {
        fabrica = new FabricaPreguntasVerdaderoFalsoConPenalidad();
        tipoPregunta = "verdadero falso penalidad";
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        ArrayList<String> opciones = new ArrayList<>();

        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(jsonObject.get("Respuesta").getAsInt());
        respuestas.add(respuesta);
        opciones.add(jsonObject.get("Opcion 1").getAsString());
        opciones.add(jsonObject.get("Opcion 2").getAsString());

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
