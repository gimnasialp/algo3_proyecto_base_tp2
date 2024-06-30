package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;


public class AnuladorDePuntaje extends ModificadorState{

    private final int LIMITE_USO=1;

    public AnuladorDePuntaje(){
        super(0);
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        for (int i = 0; i < puntajeRonda.size(); i++) {
            if (i != jugadorPosicion) {
                puntajeRonda.set(i, 0);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }

    @Override
    public void actualizarCantidadDeUso(){
        super.vecesUsado++;
    }

    public void aplicar(ArrayList<Integer> puntajeRonda,
                        ArrayList<Jugador> jugadores){

        int aplicaron = (int) jugadores.stream().map(m->m.obtenerModificadorActual())
                .filter(m->m.equals(this)).count();
        if (aplicaron == jugadores.size() ){
            // Todos usaron anuladores, asi que todos recibiran pto cero sin distincion
            puntajeRonda.replaceAll( i -> 0);
        }  else{
            for (int i=0 ; i< jugadores.size() ; i++){
                boolean aplico = jugadores.get(i).obtenerModificadorActual().equals(this);
                int puntoRespuesta = puntajeRonda.get(i);
                if(aplico //& puntoRespuesta !=0
                            ){
                    puntajeRonda.replaceAll(p-> p !=0 ?0:p );
                    puntajeRonda.set(i,puntoRespuesta);
                }

            }
        }
    }


    @Override
    public boolean habilitado() {
        return (super.vecesUsado < LIMITE_USO);
    }
}
