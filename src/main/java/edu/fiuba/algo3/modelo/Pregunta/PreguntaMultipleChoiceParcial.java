package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta {


    public PreguntaMultipleChoiceParcial(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones, String textoRespuesta) {
        super(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRespuesta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        for (Respuesta respuesta : respuestas) {

            RespuestaMultipleChoiceParcial respuestaJugador = (RespuestaMultipleChoiceParcial) respuesta;

            int puntos = 0;

            puntos += respuestaJugador.opcionesCorrectas(this.respuestaCorrecta);

            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

    @Override
    public String ObtenerTipoPregunta() {
        return "Pregunta Multiple Choice Parcial";
    }

}
