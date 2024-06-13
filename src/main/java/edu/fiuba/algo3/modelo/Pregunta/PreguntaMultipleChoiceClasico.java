package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceClasico implements Pregunta{

    public PreguntaMultipleChoiceClasico(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        //super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntos = 0;
            /*if (respuesta.comparar(this.respuestaCorrecta)) {
                puntos += 1;
            }*/
            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }
}
