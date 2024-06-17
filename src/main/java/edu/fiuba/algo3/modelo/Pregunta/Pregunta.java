package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public interface Pregunta {

    public Resultado responder(ArrayList<Respuesta> respuestas);

    public boolean mismoId(int id);

}
