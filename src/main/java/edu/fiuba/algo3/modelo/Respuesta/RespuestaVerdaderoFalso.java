package edu.fiuba.algo3.modelo.Respuesta;

import java.util.Objects;

public class RespuestaVerdaderoFalso implements Respuesta {

    private final Integer respuesta;

    public RespuestaVerdaderoFalso(Integer respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean comparar(Respuesta respuesta) {
        RespuestaVerdaderoFalso respuestaCorrecta = (RespuestaVerdaderoFalso) respuesta;
        return respuestaCorrecta.evaluar(this.respuesta);
    }

    private boolean evaluar(Integer respuesta) {
        return Objects.equals(this.respuesta, respuesta);
    }
}
