package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

import java.util.ArrayList;

public class FabricaPreguntaGroupChoice extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaGroupChoice preguntaGroupChoice = new PreguntaGroupChoice(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                (RespuestaGroupChoice) parameters[3], //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaGroupChoice;
    }

}
