package edu.fiuba.algo3.tp2;

public class Jugador {

    private String nombre = "";
    private int puntaje = 0;

    public void setNombre(String nuevo_nombre){
        this.nombre = nuevo_nombre;
    }

    public String nombre(){
        return this.nombre;
    }

    public void puntuar(int puntos){
        this.puntaje += puntos;
    }

    public int puntaje(){
        return this.puntaje;
    }
}
