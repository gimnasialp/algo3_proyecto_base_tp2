package edu.fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PreguntaMultipleChoice extends Pregunta {

    private PreguntaMultipleChoice(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        //respuestaCorrectaFormateada = parsearRespuesta(opcionesCorrectas);
    }

    /*
        private String parsearRespuesta(Set<Integer> opcionesCorrectas) {
            List<String> opcionesGrupo = new ArrayList<>();
            for (Integer n : opcionesCorrectas) {
                opcionesGrupo.add(opciones.get(n));
            }
            return String.join(", ", opcionesGrupo);
        }
    */
    public static PreguntaMultipleChoice Clasico(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, PuntajeClasico.ParaMultipleChoice(opcionesCorrectas));
        //miPreguntaMC.tipoPregunta = "Multiple Choice Clasico";
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Parcial(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajeParcial());
        // miPreguntaMC.tipoPregunta = "Multiple Choice Parcial";
        return miPreguntaMC;
    }

    public static PreguntaMultipleChoice Penalidad(String enunciado, List<String> opciones, Set<Integer> opcionesCorrectas) {
        PreguntaMultipleChoice miPreguntaMC = new PreguntaMultipleChoice(enunciado, opciones, opcionesCorrectas);
        miPreguntaMC.respuestaCorrecta = RespuestaMultipleChoice.ConPuntaje(opcionesCorrectas, new PuntajePenalidad());
        //  miPreguntaMC.tipoPregunta = "Multiple Choice Penalidad";
        return miPreguntaMC;

    }
}