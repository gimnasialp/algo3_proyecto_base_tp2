package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceConPenalidad extends Pregunta {


    public PreguntaMultipleChoiceConPenalidad(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones, String textoRespuesta) {
        super(idPregunta, tema, enunciado, respuestaCorrecta, opciones, textoRespuesta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        for (Respuesta respuesta : respuestas) {

            RespuestaMultipleChoiceConPenalidad respuestaJugador = (RespuestaMultipleChoiceConPenalidad) respuesta;

            int puntos = 0;

            puntos += respuestaJugador.opcionesCorrectas(this.respuestaCorrecta);
            puntos -= respuestaJugador.opcionesIncorrectas(this.respuestaCorrecta);

            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

    @Override
    public String ObtenerTipoPregunta() {
        return "Pregunta Multiple Choice Con Penalidad";
    }


}
