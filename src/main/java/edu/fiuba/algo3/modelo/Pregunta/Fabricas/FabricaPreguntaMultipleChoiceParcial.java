package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceEspecial;

import java.util.ArrayList;

public class FabricaPreguntaMultipleChoiceParcial extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaMultipleChoiceParcial preguntaMultipleChoiceParcial = new PreguntaMultipleChoiceParcial(
                (Integer) parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                (RespuestaMultipleChoiceEspecial) parameters[3], //RESPUESTA CORRECTA
                (ArrayList<String>) parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
        );

        //(idPregunta, tema, enunciadoPregunta, opcionCorrecta,opciones, textoRespuesta);*/
        return preguntaMultipleChoiceParcial;
    }

}
