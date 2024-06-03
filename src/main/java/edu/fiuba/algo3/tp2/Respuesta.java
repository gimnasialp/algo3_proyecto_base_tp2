package edu.fiuba.algo3.tp2;

public abstract class Respuesta {

    private final String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public abstract Integer valorClasico();
    public abstract Integer valorConPenalidad();
}