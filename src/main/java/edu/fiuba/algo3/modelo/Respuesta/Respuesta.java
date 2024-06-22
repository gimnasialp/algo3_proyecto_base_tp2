package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;

public abstract class Respuesta {
    protected Puntaje puntaje;

    public abstract Integer comparar(Respuesta respuesta);

    protected abstract boolean evaluar(Integer respuesta);
}