package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;

import java.util.ArrayList;

public class FabricaPreguntaOrderedChoice extends FabricaPreguntas {

    private Respuesta obtenerRespuesta(String respuestaCorrecta) {

        String[] lista = respuestaCorrecta.split(",");
        ArrayList<Integer> listaRespuesta = new ArrayList<>();
        for (String valor : lista) {
            listaRespuesta.add(Integer.parseInt(valor.trim()));
        }
        RespuestaOrderedChoice respuesta = new RespuestaOrderedChoice(listaRespuesta);

        return respuesta;
    }

    @Override
    public Pregunta crearPregunta(Object... parameters) {
        PreguntaOrderedChoice preguntaOrderedChoice = new PreguntaOrderedChoice(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaOrderedChoice;
    }

}
