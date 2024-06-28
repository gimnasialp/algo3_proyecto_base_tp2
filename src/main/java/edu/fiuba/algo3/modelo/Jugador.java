package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Modificador.MultiplicadorPorUno;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;

    //Multiplicador Actual
    private Multiplicador multiplicadorActual;

    //Multiplicador usado
    private List<Multiplicador> multiplicadoresEspUsados;

    //
    private Modificador modificador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadorActual = new MultiplicadorPorUno();
        this.multiplicadoresEspUsados = new ArrayList<>();
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

    public void aplicarNuevoMultiplicador(Multiplicador multiplicador){
        this.multiplicadorActual = multiplicador;
    }

    public Multiplicador obtenerModificadorActual(){
        return multiplicadorActual;
    }
    public void resetearMultiplicador(){
        multiplicadoresEspUsados.add(multiplicadorActual);
        this.multiplicadorActual = new MultiplicadorPorUno();
    }

    // Sirve para saber si el jugador ya uso el multiplicador a mostrar
    public boolean mutiplicadorFueUtilizado(Multiplicador multiplicador){
        return multiplicadoresEspUsados.stream().anyMatch(m->m.equals(multiplicador));
    }
}
