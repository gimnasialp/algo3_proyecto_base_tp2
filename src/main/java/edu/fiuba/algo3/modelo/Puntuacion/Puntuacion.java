package edu.fiuba.algo3.modelo.Puntuacion;
import java.util.ArrayList;

public class Puntuacion {
    private ArrayList<Integer> puntos;

    public Puntuacion() {
        this.puntos = new ArrayList<>();
    }
    public void agregarPuntos(int puntos){
        this.puntos.add(puntos);
    }

    public int obtenerPuntos(){
        int total = 0;
        for(int punto : this.puntos){
            total += punto;
        }
        return total;
    }

}
