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

    public boolean tieneMasPuntosQue(Jugador otroJugador) {
        return otroJugador.tieneMenosOLosMismosPuntosQue(obtenerPuntaje());
    }

    private boolean tieneMenosOLosMismosPuntosQue(int otrosPuntos){
        return (obtenerPuntaje() <= otrosPuntos);
    }

    public String getNombre() {
        return nombre;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }
}
