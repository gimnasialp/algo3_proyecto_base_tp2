package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaMultipleChoiceEspecial implements Respuesta{

    private final ArrayList<Integer> respuesta;

    public RespuestaMultipleChoiceEspecial (ArrayList<Integer> respuesta) {
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
        RespuestaMultipleChoiceEspecial respuestaCorrecta = (RespuestaMultipleChoiceEspecial) respuesta;

        int cantidad = 0;

        for (Integer choice: this.respuesta) {
            if (respuestaCorrecta.evaluar(choice)) {
                cantidad += 1;
            }
        }

        return cantidad;
    }

    public int opcionesIncorrectas(Respuesta respuesta) {
        RespuestaMultipleChoiceEspecial respuestaCorrecta = (RespuestaMultipleChoiceEspecial) respuesta;

        int cantidad = 0;

        for (Integer choice : this.respuesta) {
            if (!respuestaCorrecta.evaluar(choice)) {
                cantidad += 1;
            }
        }

        return cantidad;
    }
}
