package edu.fiuba.algo3.modelo.Puntaje;

public class PuntajePenalidad implements Puntaje {
    private Integer puntosRespuestaCorrecta;
    private Integer puntosRespuestaIncorrecta;

    public PuntajePenalidad() {
        //Puntos por default
        this.puntosRespuestaCorrecta = 1;
        this.puntosRespuestaIncorrecta = -1;
    }

    public void setPuntajes(Integer puntosRespuestaCorrecta, Integer puntosRespuestaIncorrecta) {
        this.puntosRespuestaCorrecta = puntosRespuestaCorrecta;
        this.puntosRespuestaIncorrecta = puntosRespuestaIncorrecta;
    }

    public Integer getValorRespuestaCorrecta() {
        return this.puntosRespuestaCorrecta;
    }

    public Integer getValorRespuestaIncorrecta() {
        return this.puntosRespuestaIncorrecta;
    }
}
