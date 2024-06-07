package edu.fiuba.algo3.tp2.modelo;

import java.util.Arrays;

public class PreguntaVerdaderoFalso extends Pregunta{

    private PreguntaVerdaderoFalso(String enunciado, boolean respuestaCorrecta) {
        this.enunciado = enunciado;
        opciones = Arrays.asList("Verdadero", "Falso");
        respuestaFormato = respuestaCorrecta ? "Verdadero" : "Falso";
    }

    public static PreguntaVerdaderoFalso Clasico(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, PuntajeClasico.ParaVerdaderoFalso());
      //  miPreguntaVF.tipoPregunta = "Verdadero Falso Clasico";
        return miPreguntaVF;
    }

    public static PreguntaVerdaderoFalso Penalidad(String enunciado, boolean respuestaCorrecta) {
        PreguntaVerdaderoFalso miPreguntaVF = new PreguntaVerdaderoFalso(enunciado, respuestaCorrecta);
        miPreguntaVF.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(respuestaCorrecta, new PuntajePenalidad());
        //miPreguntaVF.tipoPregunta = "Verdadero Falso Penalidad";
        return miPreguntaVF;
    }
}
