package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ExclusividadDePuntaje extends Modificador {

    private final int DUPLICIDAD = 2;

    public ExclusividadDePuntaje() {
        super(0, 2);
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass().equals(other.getClass()));
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda,
                        ArrayList<Jugador> jugadores) {

        int aplicaron = (int) jugadores.stream().map(m -> m.obtenerModificadorActual())
                .filter(m -> m.equals(this)).count();
        if (aplicaron == 1) {
            aplicarEfectoExclusividad(puntajeRonda, 1);
        } else {
            if (aplicaron >= 2) { //mas de uno usó excl.
                aplicarEfectoExclusividad(puntajeRonda, aplicaron);
            }
        }
    }

    private void aplicarEfectoExclusividad(ArrayList<Integer> puntajeRonda, int factorEfecto) {
        int respuestasCorrectas = (int) puntajeRonda.stream().filter(i -> i != 0).count();
        if (respuestasCorrectas == 1) {
            //significa que el jugador que aplico exclus. es el unico que contesto bien
            //merece solo duplicar
            int ptoDistintoDeCero = puntajeRonda.stream().filter(i -> i != 0).findFirst().get();
            int posPtjeRonda = puntajeRonda.indexOf(ptoDistintoDeCero);
            puntajeRonda.set(posPtjeRonda, puntajeRonda.get(posPtjeRonda) * DUPLICIDAD * factorEfecto);

        }
    }

}
