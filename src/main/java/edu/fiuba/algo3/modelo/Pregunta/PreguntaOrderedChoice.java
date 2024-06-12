package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        super(enunciado, opciones, respuestaCorrecta);
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {
        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas){
            int puntos = 0;
            if (respuestaCorrecta.comparar(respuesta)){
                puntos += 1;
            }
            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }
}
