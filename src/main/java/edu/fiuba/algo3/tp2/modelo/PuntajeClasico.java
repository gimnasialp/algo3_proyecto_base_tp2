package edu.fiuba.algo3.tp2.modelo;

import java.util.List;

public class PuntajeClasico implements Puntaje{

    private int aciertosEsperados;

    private PuntajeClasico(){
        this.aciertosEsperados = 1;
    }

    public static PuntajeClasico PuntajeParaVerdaderoFalso() {
        return new PuntajeClasico();
    }

    public static PuntajeClasico PuntajeParaMultipleChoice(RespuestaMultipleChoice respuestaCorrecta) {
        PuntajeClasico miTipoPuntaje = new PuntajeClasico();
        miTipoPuntaje.aciertosEsperados = respuestaCorrecta.size();
        return miTipoPuntaje;
    }

    public Integer puntuar(List<Integer> evaluacion) {
        return this.aciertosEsperados == evaluacion.get(0) && evaluacion.get(1) == 0 ? 1 : 0;
    }
}
