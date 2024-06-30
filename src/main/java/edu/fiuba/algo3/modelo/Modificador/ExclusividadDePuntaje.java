package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public class ExclusividadDePuntaje extends ModificadorState{

    private final int LIMITE_USO=2;

    private final int DUPLICIDAD=2;
    public ExclusividadDePuntaje(){
        super(0);
    }
    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {

        int cantidadJugadoresQueRespondieronBien = puntajeRonda.size();

        for (Integer puntos: puntajeRonda){
            if(puntos == 0) {
                cantidadJugadoresQueRespondieronBien -= 1;
            }
        }

        if (cantidadJugadoresQueRespondieronBien == 1) {
            int i = 0;
            while (i < puntajeRonda.size() && puntajeRonda.get(i) == 0) {
                i++;
            }
            puntajeRonda.set(i, puntajeRonda.get(i)*2);
        }
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass().equals(other.getClass()));
    }

    @Override
    public void actualizarCantidadDeUso(){
        super.vecesUsado++;
    }

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda,
                                ArrayList<Jugador> jugadores){

        int aplicaron = (int) jugadores.stream().map(m->m.obtenerModificadorActual())
                .filter(m->m.equals(this)).count();
        if (aplicaron ==1 ){
            aplicarEfectoExclusividad(puntajeRonda,1);
        }  else{
            if(aplicaron >=2) { //mas de uno usó exclusiv
                /* int respuestasCorrectas = (int) puntajeRonda.stream().filter(i -> i != 0).count();
                if(respuestasCorrectas==1){
                    //significa que el jugador que aplico exclus. es el unico que contesto bien
                    //merece solo duplicar
                    int ptoDistintoDeCero = puntajeRonda.stream().filter(i->i!=0).findFirst().get();
                    int posPtjeRonda= puntajeRonda.indexOf(ptoDistintoDeCero);
                    puntajeRonda.set(posPtjeRonda, puntajeRonda.get(posPtjeRonda) *DUPLICIDAD * aplicaron );
                }*/
                aplicarEfectoExclusividad(puntajeRonda,aplicaron);
            }


        }

                //.count()noneMatch(m->m.equals(multiplicador));
    }

    private  void aplicarEfectoExclusividad(ArrayList<Integer> puntajeRonda, int factorEfecto) {
        int respuestasCorrectas = (int) puntajeRonda.stream().filter(i->i!=0).count();
        if(respuestasCorrectas==1){
            //significa que el jugador que aplico exclus. es el unico que contesto bien
            //merece solo duplicar
            int ptoDistintoDeCero = puntajeRonda.stream().filter(i->i!=0).findFirst().get();
            int posPtjeRonda= puntajeRonda.indexOf(ptoDistintoDeCero );
            puntajeRonda.set(posPtjeRonda, puntajeRonda.get(posPtjeRonda) * DUPLICIDAD * factorEfecto);

        }
    }

    public boolean habilitado(){
        return (super.vecesUsado < LIMITE_USO);
    }
}
