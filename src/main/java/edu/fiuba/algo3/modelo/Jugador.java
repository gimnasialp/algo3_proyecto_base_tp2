package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Modificador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jugador {

    private String nombre;
    private Puntaje puntaje;
    private Multiplicador multiplicadorActual;
    private List<Multiplicador> multiplicadoresDisponibles;

    private Modificador modificadorActual;

    private List<Modificador> modificadoresDisponibles;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = new Puntaje();
        this.multiplicadorActual = new MultiplicadorPorUno();
        this.multiplicadoresDisponibles = new ArrayList<>(Arrays.asList(new MultiplicarPorDos(),new MultiplicarPorTres()));
        this.modificadorActual = new ModificadorNulo();
        this.modificadoresDisponibles = new ArrayList<>(Arrays.asList(new ExclusividadDePuntaje(),new AnuladorDePuntaje()));
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

    public Modificador obtenerModificadorActual(){
        return modificadorActual;
    }

    public Multiplicador obtenerMultiplicador(){
        return multiplicadorActual;
    }

    public List<Multiplicador> obtenerMultiplicadoresDisponibles(){
        return multiplicadoresDisponibles;
    }

    public void deshabilitarMultiplicador(Multiplicador modificador) {
        obtenerMultiplicadoresDisponibles().remove(modificador);
    }

    // Sirve para saber si el jugador ya uso el multiplicador a mostrar
    public boolean multiplicadorFueUtilizado(Multiplicador multiplicador){
        return multiplicadoresDisponibles.stream().noneMatch(m->m.equals(multiplicador));
    }

    public void resetearComodines() {
        multiplicadorActual = new MultiplicadorPorUno();
        modificadorActual = new ModificadorNulo();
    }

    public void aplicarNuevoModificador(Modificador modificador) {
        this.modificadorActual = modificador;
        actualizarUso(modificador);
    }

    private void actualizarUso(Modificador modificador) {
        modificadoresDisponibles.stream().filter(m->m.equals(modificador))
                .forEach(m->m.actualizarCantidadDeUso());
    }

    //para la vista
    public boolean habilitado(Modificador modificador){
        Modificador modificadorState = modificadoresDisponibles.stream().
                                            filter(m->m.equals(modificador)).findFirst().get();
        return modificadorState.habilitado();
    }


}
