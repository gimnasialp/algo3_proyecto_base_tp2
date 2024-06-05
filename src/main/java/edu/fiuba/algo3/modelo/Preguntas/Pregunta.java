package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public interface Pregunta {

     public abstract ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas);

}
