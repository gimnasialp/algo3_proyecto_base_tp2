package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaMultipleChoiceConPenalidad extends Pregunta {

    public PreguntaMultipleChoiceConPenalidad(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();


        for (Respuesta respuesta: respuestas) {
            RespuestaMultipleChoice respuestaJugador = (RespuestaMultipleChoice) respuesta;
            int puntosObtenidos = 0;

            puntosObtenidos += respuestaJugador.opcionesCorrectas(respuestaCorrecta);
            puntosObtenidos -= respuestaJugador.opcionesIncorrectas(respuestaCorrecta);

            resultado.agregarPuntos(puntosObtenidos);
        }

        return resultado;
    }
}
