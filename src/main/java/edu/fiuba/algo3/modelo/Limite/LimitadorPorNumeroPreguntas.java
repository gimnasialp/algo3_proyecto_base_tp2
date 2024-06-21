package edu.fiuba.algo3.modelo.Limite;

public class LimitadorPorNumeroPreguntas extends Limite {

    private int cantidadPreguntas;
    public LimitadorPorNumeroPreguntas(int cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    @Override
    public void limitar() {

    }

    public int obtenerLimitePreguntas() {
        return cantidadPreguntas;
    }
}
