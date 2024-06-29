package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico extends Pregunta{



    public PreguntaMultipleChoiceClasico(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String>opciones, String textoRespuesta) {
        super(idPregunta,tema,enunciado,respuestaCorrecta,opciones,textoRespuesta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntos = 0;
            if (respuesta.comparar(this.respuestaCorrecta)) {
                puntos += 1;
            }
            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

    @Override
    public String ObtenerTipoPregunta() {
        return "Pregunta Multiple Choice Clasico";
    }

}
