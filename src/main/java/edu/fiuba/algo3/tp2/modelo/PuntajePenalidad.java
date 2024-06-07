package edu.fiuba.algo3.tp2.modelo;

import java.util.List;

public class PuntajePenalidad implements Puntaje{
    @Override
    public Integer puntuar(Integer aciertos, Integer errores) {
        return aciertos - errores;
    }

    @Override
    public boolean permiteMultiplicadores() {
        return true;
    }

    @Override
    public boolean permiteExclusividad() {
        return false;
    }
}
