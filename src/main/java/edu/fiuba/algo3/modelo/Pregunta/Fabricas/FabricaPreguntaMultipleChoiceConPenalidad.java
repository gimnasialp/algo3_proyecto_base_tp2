package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.*;
import java.util.ArrayList;

public class FabricaPreguntaMultipleChoiceConPenalidad extends FabricaPreguntas{

    private Respuesta obtenerRespuesta(String respuestaCorrecta){

        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceConPenalidad respuesta = new RespuestaMultipleChoiceConPenalidad(listaRespuesta);

        return respuesta;
    }

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaMultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad = new PreguntaMultipleChoiceConPenalidad(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaMultipleChoiceConPenalidad;
    }

}
