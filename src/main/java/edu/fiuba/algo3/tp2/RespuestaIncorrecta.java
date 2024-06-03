package edu.fiuba.algo3.tp2;

public class RespuestaIncorrecta extends Respuesta {

    public RespuestaIncorrecta(String respuesta) {
        super(respuesta);
    }

    @Override
    public Integer valorClasico() {
        return 0;
    }

    @Override
    public Integer valorConPenalidad() {
        return -1;
    }
}
