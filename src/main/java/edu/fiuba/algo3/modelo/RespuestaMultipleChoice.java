package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RespuestaMultipleChoice implements Respuesta{

    private ArrayList<String> respuesta;

    public RespuestaMultipleChoice (ArrayList<String> respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        return true;
    }

    private boolean evaluar(String choice) {
        return this.respuesta.contains(choice);
    }

    public boolean todasLasRespuestasSonCorrectas(RespuestaMultipleChoice respuestaJugador) {
        return this.respuesta.size() == respuestaJugador.opcionesCorrectas(this);
    }

    public int opcionesCorrectas(Respuesta respuesta) {

        int cantidad = 0;
        RespuestaMultipleChoice respuestaMC = (RespuestaMultipleChoice) respuesta;

        for (String choice: this.respuesta) {
            if (respuestaMC.evaluar(choice)) {
                cantidad += 1;
            }
        }

        return cantidad;
    }

    public int opcionesIncorrectas(Respuesta respuesta) {

        int cantidad = 0;
        RespuestaMultipleChoice respuestaMC = (RespuestaMultipleChoice) respuesta;

        for (String choice: this.respuesta) {
            if (!respuestaMC.evaluar(choice)) {
                cantidad += 1;
            }

        }
        return cantidad;
    }
}
