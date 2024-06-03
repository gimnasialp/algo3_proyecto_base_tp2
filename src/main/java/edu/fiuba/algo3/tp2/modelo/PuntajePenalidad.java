package edu.fiuba.algo3.tp2.modelo;

import java.util.List;

public class PuntajePenalidad implements Puntaje{
    public Integer puntuar(List<Integer> evaluacion){

        return evaluacion.get(0) - evaluacion.get(1);
    }
}
