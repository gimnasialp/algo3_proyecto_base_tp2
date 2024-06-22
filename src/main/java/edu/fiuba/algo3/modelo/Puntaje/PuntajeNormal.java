package edu.fiuba.algo3.modelo.Puntaje;

public class PuntajeNormal implements Puntaje {
    private Integer puntosRespuestaCorrecta;
    private Integer puntosRespuestaIncorrecta;

    public PuntajeNormal() {
        //Puntos por default
        this.puntosRespuestaCorrecta = 1;
        this.puntosRespuestaIncorrecta = 0;
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
