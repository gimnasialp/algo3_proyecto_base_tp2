package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class RespuestaVerdaderoFalso implements Respuesta {

    private String respuesta;

    public RespuestaVerdaderoFalso(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaVerdaderoFalso respuestaVoF = (RespuestaVerdaderoFalso) respuesta;
        return respuestaVoF.evaluar(this.respuesta);
    }

    private boolean evaluar(String respuesta) {
        return Objects.equals(this.respuesta, respuesta);
    }
}
