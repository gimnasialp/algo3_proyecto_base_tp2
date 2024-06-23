package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;


import java.util.ArrayList;

public class FabricaPreguntasVerdaderoFalsoConPenalidad  extends FabricaPreguntas {

    protected Respuesta obtenerRespuesta(String respuestaCorrecta) {
        int respuestaNumerica = Integer.parseInt(respuestaCorrecta);
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(respuestaNumerica);
        return respuesta;

    }
    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaVerdaderoFalsoConPenalidad preguntaVerdaderoFalsoClasico = new PreguntaVerdaderoFalsoConPenalidad(
                (Integer)parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                obtenerRespuesta(parameters[3].toString()), //RESPUESTA CORRECTA
                (ArrayList<String>)parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaVerdaderoFalsoClasico;
    }

}
