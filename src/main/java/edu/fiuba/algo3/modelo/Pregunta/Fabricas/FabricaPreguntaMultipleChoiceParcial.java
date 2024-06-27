package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;

import java.util.ArrayList;

public class FabricaPreguntaMultipleChoiceParcial extends FabricaPreguntas {


    private Respuesta obtenerRespuesta(String respuestaCorrecta){

        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceParcial respuesta = new RespuestaMultipleChoiceParcial(listaRespuesta);

        return respuesta;
    }
    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaMultipleChoiceParcial preguntaMultipleChoiceParcial = new PreguntaMultipleChoiceParcial(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );

        return preguntaMultipleChoiceParcial;
    }

}
