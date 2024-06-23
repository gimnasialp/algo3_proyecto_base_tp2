package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public abstract class RespuestaVerdaderoFalso extends Respuesta {
    protected Integer respuesta;

    @Override
    public Integer comparar(Respuesta respuesta) {
        RespuestaVerdaderoFalso respuestaCorrecta = (RespuestaVerdaderoFalso) respuesta;
        if (respuestaCorrecta.evaluar(this.respuesta)) {
            return this.puntaje.getValorRespuestaCorrecta();
        }

        return this.puntaje.getValorRespuestaIncorrecta();
    }

    public boolean evaluar(Integer respuesta) {
        return this.respuesta.equals(respuesta);
    }
}
