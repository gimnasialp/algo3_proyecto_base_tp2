package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public interface Pregunta {

    public abstract Resultado responder(ArrayList<Respuesta> respuestas);
}
