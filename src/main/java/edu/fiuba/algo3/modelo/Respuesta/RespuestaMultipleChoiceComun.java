package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajePenalidad;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaMultipleChoiceComun extends Respuesta {
    private ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceComun(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajePenalidad();
    }

    @Override
    public Integer comparar(Respuesta respuesta) {
        for (Integer respuestaElegida : this.respuesta) {
            if (!respuesta.evaluar(respuestaElegida)) {
                return this.puntaje.getValorRespuestaIncorrecta();
            }
        }

        RespuestaMultipleChoiceComun respuestaCorrecta = (RespuestaMultipleChoiceComun) respuesta;
        return respuestaCorrecta.evaluar(this.respuesta);
    }

    protected boolean compararTamanio(ArrayList<Integer> respuesta) {
        return this.respuesta.size() == respuesta.size();
    }

    public boolean evaluar(ArrayList<Integer> respuesta) {
        return this.respuesta.stream().sorted().equals(respuesta.stream().sorted());
    }
}
