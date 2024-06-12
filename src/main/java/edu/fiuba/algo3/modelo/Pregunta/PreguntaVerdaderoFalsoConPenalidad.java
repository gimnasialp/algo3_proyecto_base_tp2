package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoConPenalidad extends Pregunta {

    public PreguntaVerdaderoFalsoConPenalidad(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntosObtenidos = 0;
            if (mismaRespuesta(respuesta)){
                puntosObtenidos += 1;
            } else {
                puntosObtenidos -= 1;
            }
            resultado.agregarPuntos(puntosObtenidos);
        }

        return resultado;
    }

    private boolean mismaRespuesta(Respuesta respuesta) {
        return respuesta.comparar(this.respuestaCorrecta);
    }
}
