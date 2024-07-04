package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;

import java.util.ArrayList;

public class FabricaPreguntaMultipleChoiceClasico extends FabricaPreguntas {

    private Respuesta obtenerRespuesta(String respuestaCorrecta) {

        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaMultipleChoiceClasico respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);

        return respuesta;
    }

    @Override
    public Pregunta crearPregunta(Object... parameters) {
        PreguntaMultipleChoiceClasico preguntaMultipleChoiceClasico = new PreguntaMultipleChoiceClasico(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaMultipleChoiceClasico;
    }

}
