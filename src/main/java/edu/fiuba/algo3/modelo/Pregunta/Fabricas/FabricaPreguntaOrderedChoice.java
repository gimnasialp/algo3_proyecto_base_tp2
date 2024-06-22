package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.*;

import java.util.ArrayList;

public class FabricaPreguntaOrderedChoice extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaOrderedChoice preguntaOrderedChoice = new PreguntaOrderedChoice(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                (RespuestaOrderedChoice) parameters[3], //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );


        return preguntaOrderedChoice;
    }

}
