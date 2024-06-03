package edu.fiuba.algo3.tp2;

import java.util.ArrayList;

public class MultipleChoiceConPenalidad extends MultipleChoice {

    public MultipleChoiceConPenalidad(String unEnunciado, ArrayList<Respuesta> opciones) {
        super(unEnunciado, opciones);
    }

    @Override
    public int evaluar(ArrayList<Respuesta> respuestas) {
        Integer puntos = 0;
        for (Respuesta respuesta : respuestas) {
            puntos += respuesta.valorConPenalidad();
        }
        return puntos;
    }
}
