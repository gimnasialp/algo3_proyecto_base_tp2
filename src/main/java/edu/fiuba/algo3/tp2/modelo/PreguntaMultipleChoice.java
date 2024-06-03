package edu.fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaMultipleChoice {

    private final String enunciado;
    private final List<String> opciones;
    private final RespuestaMultipleChoice respuestaCorrecta;
    private Puntaje puntaje;

    private PreguntaMultipleChoice(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = new RespuestaMultipleChoice(opcionesCorrectas);
    }
    public static PreguntaMultipleChoice Parcial(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = new PuntajeParcial();
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Penalidad(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = new PuntajePenalidad();
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Clasico(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.puntaje = PuntajeClasico.PuntajeParaMultipleChoice(new RespuestaMultipleChoice(opcionesCorrectas));
        return miPreguntaMC;
    }

    public List<Integer> responder(List<RespuestaMultipleChoice> respuestas) {
        List<Integer> puntos = new ArrayList<>();
        for (RespuestaMultipleChoice respuestaUsuario : respuestas) {
            puntos.add(this.puntaje.puntuar(this.respuestaCorrecta.evaluar(respuestaUsuario)));
        }
        return puntos;
    }
}
