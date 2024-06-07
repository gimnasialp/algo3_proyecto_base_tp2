package edu.fiuba.algo3.tp2.modelo;

import java.util.List;
import java.util.Set;

public class PuntajeClasico implements Puntaje{

    private int aciertosEsperados;

    private PuntajeClasico() {
    }

    public static PuntajeClasico ParaVerdaderoFalso() {
        PuntajeClasico miPuntaje = new PuntajeClasico();
        miPuntaje.aciertosEsperados = 1;
        return miPuntaje;
    }

    public static PuntajeClasico ParaMultipleChoice(Set<Integer> opcionesCorrectas) {
        PuntajeClasico miPuntaje = new PuntajeClasico();
        miPuntaje.aciertosEsperados = opcionesCorrectas.size();
        return miPuntaje;
    }

    @Override
    public Integer puntuar(Integer aciertos, Integer errores) {
        return aciertosEsperados == aciertos && errores == 0 ? 1 : 0;
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
