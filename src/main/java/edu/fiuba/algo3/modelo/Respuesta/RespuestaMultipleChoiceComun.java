package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajePenalidad;

import java.util.ArrayList;

public class RespuestaMultipleChoiceComun extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceComun(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajePenalidad();
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        RespuestaMultipleChoiceComun respuestaCorrecta = (RespuestaMultipleChoiceComun) respuesta;
        if (respuestaCorrecta.evaluar(this.respuesta)) {
            return this.puntaje.getValorRespuestaCorrecta();
        }
        return this.puntaje.getValorRespuestaIncorrecta();
    }

    public boolean evaluar(ArrayList<Integer> respuesta) {
        return this.respuesta.stream().sorted().equals(respuesta.stream().sorted());
    }
}
