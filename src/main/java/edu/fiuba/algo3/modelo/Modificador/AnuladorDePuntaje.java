package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;


public class AnuladorDePuntaje extends Modificador {

    public AnuladorDePuntaje() {
        super(0, 1);
    }


    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda,
                        ArrayList<Jugador> jugadores) {

        int aplicaron = (int) jugadores.stream().map(m -> m.obtenerModificadorActual())
                .filter(m -> m.equals(this)).count();
        if (aplicaron == jugadores.size()) {
            // Todos usaron anuladores, asi que todos recibiran pto cero sin distincion
            puntajeRonda.replaceAll(i -> 0);
        } else {
            for (int i = 0; i < jugadores.size(); i++) {
                boolean aplico = jugadores.get(i).obtenerModificadorActual().equals(this);
                int puntoRespuesta = puntajeRonda.get(i);
                if (aplico) {
                    puntajeRonda.replaceAll(p -> p != 0 ? 0 : p);
                    puntajeRonda.set(i, puntoRespuesta);
                }
            }
        }
    }

}
