package edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class MultipleChoice implements Pregunta {


    private final String enunciado;
    protected ArrayList<Respuesta> opciones;

    public MultipleChoice(String unEnunciado, ArrayList<Respuesta> opciones) {
        this.enunciado = unEnunciado;
        this.opciones = opciones;
    }

    public abstract int evaluar(ArrayList<Respuesta> respuestas);

    public ArrayList<Integer> responder(ArrayList<ArrayList<Respuesta>> respuestas) {
        ArrayList<Integer> puntos = new ArrayList();
        for (ArrayList<Respuesta> respuestasUsuario : respuestas) {
            puntos.add(evaluar(respuestasUsuario));
        }
        return puntos;
    }
}
