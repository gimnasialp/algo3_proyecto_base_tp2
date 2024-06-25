package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaMultipleChoiceParcial implements Respuesta{

    private final ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceParcial(ArrayList<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        return true;
    }

    private boolean evaluar(Integer choice) {
        return this.respuesta.contains(choice);
    }

    public int opcionesCorrectas(Respuesta respuesta) {
        RespuestaMultipleChoiceParcial respuestaCorrecta = (RespuestaMultipleChoiceParcial) respuesta;

        int cantidad = 0;

        for (Integer choice: this.respuesta) {
            if (respuestaCorrecta.evaluar(choice)) {
                cantidad += 1;
            }
        }

        return cantidad;
    }

}
