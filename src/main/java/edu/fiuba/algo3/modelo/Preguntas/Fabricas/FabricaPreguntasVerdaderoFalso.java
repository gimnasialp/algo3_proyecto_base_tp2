package edu.fiuba.algo3.modelo.Preguntas.Fabricas;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.VoF.VerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class FabricaPreguntasVerdaderoFalso extends FabricaPreguntas {

    @Override
    public Pregunta crearPregunta(Object ... parameters) {
        VerdaderoFalsoClasico preguntaVerdaderoFalsoClasico = new VerdaderoFalsoClasico(parameters[0].toString(), (ArrayList<Respuesta>) parameters[1]);
        return preguntaVerdaderoFalsoClasico;
    }
}
