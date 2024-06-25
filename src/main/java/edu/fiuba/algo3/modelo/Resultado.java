package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Modificador.Modificador;

import java.util.ArrayList;

public class Resultado {

    private ArrayList<Integer> puntajeRonda;

    public Resultado () {
        this.puntajeRonda = new ArrayList<>();
    }

    public void agregarPuntos(int puntos) {
        puntajeRonda.add(puntos);
    };

    public int obtenerPuntosDelJugador(int posicionJugador) {
        return puntajeRonda.get(posicionJugador);
    };

    public void usarModificador(Modificador modificador, int posicionJugador) {
        modificador.aplicar(puntajeRonda, posicionJugador);
    }

    public void asignarPuntosALosJugadores(ArrayList<Jugador> jugadores) {

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).asignarPuntos(puntajeRonda.get(i));
        }

    }
}
