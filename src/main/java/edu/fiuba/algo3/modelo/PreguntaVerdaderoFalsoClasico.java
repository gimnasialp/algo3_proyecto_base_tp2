package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoClasico extends Pregunta {

    public PreguntaVerdaderoFalsoClasico(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntosObtenidos = 0;
            if (mismaRespuesta(respuesta)){
                puntosObtenidos += 1;
            }
            resultado.agregarPuntos(puntosObtenidos);
        }

        return resultado;
    }

    private boolean mismaRespuesta(Respuesta respuesta) {
        return respuesta.comparar(this.respuestaCorrecta);
    }

}
