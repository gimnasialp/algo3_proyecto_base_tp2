package edu.fiuba.algo3.tp2.modelo;

import java.util.List;

public interface Puntaje {

    Integer puntuar(Integer aciertos, Integer errores);

    boolean permiteMultiplicadores();

    boolean permiteExclusividad();
}
