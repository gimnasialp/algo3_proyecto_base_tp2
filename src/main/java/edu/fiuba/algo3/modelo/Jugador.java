package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
    }

    public void asignarPuntos(int puntos) {
        puntaje.asignarPuntos(puntos);
    }

    public int obtenerPuntaje() {
        return puntaje.obtenerPuntos();
    }
}
