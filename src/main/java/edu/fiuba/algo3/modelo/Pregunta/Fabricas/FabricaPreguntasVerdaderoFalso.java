package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;

import java.util.ArrayList;

public class FabricaPreguntasVerdaderoFalso extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        PreguntaVerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = new PreguntaVerdaderoFalsoClasico(
                (Integer)parameters[0],//ID
                parameters[1].toString(), //TEMA
                parameters[2].toString(), //ENUNCIADO
                (RespuestaVerdaderoFalso) parameters[3], //RESPUESTA CORRECTA
                (ArrayList<String>)parameters[4], //OPCIONES
                parameters[5].toString() //TEXTORESPUESTA
                );

        //(idPregunta, tema, enunciadoPregunta, opcionCorrecta,opciones, textoRespuesta);*/
        return preguntaVerdaderoFalsoClasico;
    }
}
