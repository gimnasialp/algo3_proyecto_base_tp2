package edu.fiuba.algo3.modelo.Lector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Preguntas.Fabricas.FabricaPreguntasVerdaderoFalso;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;

import java.util.ArrayList;

public class VerdaderoFalsoClasicoParser implements Parser{

    private FabricaPreguntasVerdaderoFalso fabricaPreguntasVerdaderoFalso;
    private int idPregunta;
    private String tema;
    private String tipoPregunta;
    private String textoRespuesta;
    private ArrayList<String> opciones = new ArrayList<>();
    private String enunciadoPregunta;

    public VerdaderoFalsoClasicoParser() {
        FabricaPreguntasVerdaderoFalso fabricaPreguntasVerdaderoFalso = new FabricaPreguntasVerdaderoFalso();
    }

    private Pregunta OrganizarDatos(JsonObject jsonObject){
        ArrayList<Respuesta> Respuesta = new ArrayList<>();
        ArrayList<String> opciones = new ArrayList<>();


        idPregunta = jsonObject.get("ID").getAsInt();
        tema = jsonObject.get("Tema").getAsString();
        tipoPregunta = jsonObject.get("Tipo").getAsString();
        textoRespuesta = jsonObject.get("Texto respuesta").getAsString();
        String opcionCorrecta = jsonObject.get("Respuesta").getAsString();

        Respuesta.add(new RespuestaCorrecta(opcionCorrecta));
        opciones.add(jsonObject.get("Opcion 1").getAsString());
        opciones.add(jsonObject.get("Opcion 2").getAsString());
        enunciadoPregunta = jsonObject.get("Pregunta").getAsString();
        Pregunta pregunta = fabricaPreguntasVerdaderoFalso.crearPregunta(idPregunta, tema, enunciadoPregunta, opcionCorrecta,opciones, textoRespuesta);
        return pregunta;
    }

    @Override
    public Pregunta parse(JsonElement preguntaJson) {
        return OrganizarDatos(preguntaJson.getAsJsonObject());
    }

}
