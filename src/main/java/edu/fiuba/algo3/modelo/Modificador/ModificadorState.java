package edu.fiuba.algo3.modelo.Modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

public abstract class ModificadorState {

   protected int vecesUsado;

   public ModificadorState(int vecesUsado){
      this.vecesUsado=vecesUsado;
   }

   // void aplicarState(ModificadorContextState modificadorContextState,
                    //  ArrayList<Integer> puntajeRonda, int jugadorPosicion);
   public abstract void aplicar(ArrayList<Integer> puntajeRonda, int jugadorPosicion);

   public abstract void actualizarCantidadDeUso();

   public abstract void aplicar(ArrayList<Integer> puntajeRonda,
                              ArrayList<Jugador> jugadores);

   public abstract boolean habilitado();

}
