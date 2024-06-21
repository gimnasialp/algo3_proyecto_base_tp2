package edu.fiuba.algo3.modelo.Limite;

public abstract class Limite {

    private int puntos;

    public  Limite(int puntos){
        this.puntos = puntos;
    }

    protected Limite() {
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public abstract void limitar();


}
