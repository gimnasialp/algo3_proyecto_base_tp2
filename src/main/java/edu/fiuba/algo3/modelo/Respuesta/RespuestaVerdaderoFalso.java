package edu.fiuba.algo3.modelo.Respuesta;

public abstract class RespuestaVerdaderoFalso extends Respuesta {
    protected Integer respuesta;

    @Override
    public Integer comparar(Respuesta respuesta) {
        if (respuesta.evaluar(this.respuesta)) {
            return this.puntaje.getValorRespuestaCorrecta();
        }

        return this.puntaje.getValorRespuestaIncorrecta();
    }

    @Override
    public boolean evaluar(Integer respuesta) {
        return this.respuesta.equals(respuesta);
    }
}
