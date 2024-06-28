package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicadorPorUno;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;
    private Modificador modificadorActual;

    private List<Modificador> modificadoresEspUsados;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.modificadorActual = new MultiplicadorPorUno();
        this.modificadoresEspUsados = new ArrayList<>();
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

    public void aplicarNuevoMultiplicador(Modificador modificador){
        this.modificadorActual = modificador;
    }

    public Modificador obtenerModificadorActual(){
        return modificadorActual;
    }
    public void resetearMultiplicador(){
        modificadoresEspUsados.add(modificadorActual);
        this.modificadorActual = new MultiplicadorPorUno();
    }

    public boolean modificadorUtilizado(Modificador modificador){
        return modificadoresEspUsados.stream().anyMatch(m->m.equals(modificador));
    }
}
