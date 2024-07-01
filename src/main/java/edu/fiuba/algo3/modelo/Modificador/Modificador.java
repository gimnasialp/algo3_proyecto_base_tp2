package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public abstract class Modificador {
    protected int vecesUsado;

    protected int limiteParaUso;

    public Modificador(int vecesUsado, int limiteParaUso) {
        this.vecesUsado = vecesUsado;
        this.limiteParaUso = limiteParaUso;
    }

    //De ale
    //public abstract void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion);

    public void actualizarCantidadDeUso() {
        vecesUsado++;
    }

    public abstract void aplicar(ArrayList<Integer> puntajeRonda,
                                 ArrayList<Jugador> jugadores);

    public boolean habilitado() {
        return vecesUsado < limiteParaUso;
    }

}
