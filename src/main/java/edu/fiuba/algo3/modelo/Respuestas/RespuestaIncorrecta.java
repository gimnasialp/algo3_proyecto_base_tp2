package edu.fiuba.algo3.modelo.Respuestas;

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
