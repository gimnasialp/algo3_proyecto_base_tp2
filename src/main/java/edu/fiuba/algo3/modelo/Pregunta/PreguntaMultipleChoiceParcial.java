package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    public PreguntaMultipleChoiceParcial(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            RespuestaMultipleChoice respuestaJugador = (RespuestaMultipleChoice) respuesta;
            int puntosObtenidos = 0;

            puntosObtenidos += respuestaJugador.opcionesCorrectas(respuestaCorrecta);

            resultado.agregarPuntos(puntosObtenidos);
        }

        return resultado;
    }
}
