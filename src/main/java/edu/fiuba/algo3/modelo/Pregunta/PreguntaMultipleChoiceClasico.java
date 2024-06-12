package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntosObtenidos = 0;
            if (todosSonCorrectos(respuesta)) {
                puntosObtenidos += 1;
            }
            resultado.agregarPuntos(puntosObtenidos);
        }

        return resultado;
    }

    private boolean todosSonCorrectos(Respuesta respuesta) {
        RespuestaMultipleChoice respuestaJugador = (RespuestaMultipleChoice) respuesta;
        RespuestaMultipleChoice respuestaCorrecta = (RespuestaMultipleChoice) this.respuestaCorrecta;
        return respuestaCorrecta.todasLasRespuestasSonCorrectas(respuestaJugador);
    }

}
