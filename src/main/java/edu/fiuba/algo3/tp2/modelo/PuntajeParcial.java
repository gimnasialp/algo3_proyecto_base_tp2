package edu.fiuba.algo3.tp2.modelo;

import java.util.List;

public class PuntajeParcial implements Puntaje{


    @Override
    public Integer puntuar(Integer aciertos, Integer errores) {
        return errores == 0 ? aciertos : 0;
    }

    @Override
    public boolean permiteMultiplicadores() {
        return false;
    }

    @Override
    public boolean permiteExclusividad() {
        return true;
    }

}
