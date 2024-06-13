package edu.fiuba.algo3.modelo.Pregunta.Fabricas;

import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.*;

import java.util.ArrayList;

public class FabricaPreguntaMultipleChoiceClasico extends FabricaPreguntas {
    @Override
    public Pregunta crearPregunta(Object... parameters) {
        return null;//new MultipleChoiceClasico((String) parameters[0], (ArrayList<Respuesta>) parameters[1]);
    }
}
