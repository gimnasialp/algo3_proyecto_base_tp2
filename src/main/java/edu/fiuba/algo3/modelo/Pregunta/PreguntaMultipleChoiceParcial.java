package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceEspecial;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    public PreguntaMultipleChoiceParcial(int idPregunta,String tema, String enunciado,
                                         Respuesta respuestaCorrecta,ArrayList<String>opciones,String textoRespuesta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {

            RespuestaMultipleChoiceEspecial respuestaJugador = (RespuestaMultipleChoiceEspecial) respuesta;

            int puntos = 0;

            puntos += respuestaJugador.opcionesCorrectas(this.respuestaCorrecta);

            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }
}
