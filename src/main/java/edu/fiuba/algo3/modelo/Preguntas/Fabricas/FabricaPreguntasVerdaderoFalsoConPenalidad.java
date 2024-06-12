package edu.fiuba.algo3.modelo.Preguntas.Fabricas;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class FabricaPreguntasVerdaderoFalsoConPenalidad  extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object... parameters) {
        return new VerdaderoFalsoConPenalidad((String) parameters[0], (ArrayList<Respuesta>) parameters[1]);
    }

}
