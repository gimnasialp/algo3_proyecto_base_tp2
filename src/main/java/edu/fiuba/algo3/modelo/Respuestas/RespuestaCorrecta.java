package edu.fiuba.algo3.modelo.Respuestas;

public class RespuestaCorrecta extends Respuesta {

    public RespuestaCorrecta(String respuesta) {
        super(respuesta);
    }

    @Override
    public Integer valorClasico() {
        return 1;
    }

    @Override
    public Integer valorConPenalidad() {
        return 1;
    }
}
