package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;

    public void asignarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public int obtenerPuntos() {
        return this.puntaje;
    }
}
