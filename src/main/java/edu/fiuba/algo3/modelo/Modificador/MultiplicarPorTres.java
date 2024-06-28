package edu.fiuba.algo3.modelo.Modificador;

import java.util.ArrayList;

public class MultiplicarPorTres implements Multiplicador {

    private final int MULTIPLICADOR = 3;

 //   private int usado =0;

  //  private final int limite =1;

    @Override
    public void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion) {
        puntajeRonda.set(jugadorPosicion, puntajeRonda.get(jugadorPosicion)*MULTIPLICADOR);
       // ++usado;
    }

   // public boolean tieneMultiplicadorActivo(){
       // return  limite<usado;
   // }

    @Override
    public boolean equals(Object other) {
        return this.getClass().isInstance(other.getClass());
    }

}
