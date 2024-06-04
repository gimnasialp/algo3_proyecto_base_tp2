package edu.fiuba.algo3.tp2.modelo;

import java.util.Set;

public class RespuestaGroupChoice {

    private final Set<Integer> grupoA;
    private final Set<Integer> grupoB;

    public RespuestaGroupChoice(Set<Integer> grupoA, Set<Integer> grupoB){
        this.grupoA = grupoA;
        this.grupoB = grupoB;
    }

    public boolean equals(RespuestaGroupChoice otraRespuesta) {
        return otraRespuesta.equals(this.grupoA, this.grupoB);
    }

    private boolean equals(Set<Integer> grupoA, Set<Integer> grupoB) {
        return (this.grupoA.equals(grupoA) && this.grupoB.equals(grupoB));
    }

    public Integer evaluar(RespuestaGroupChoice respuestaUsuario){
        return this.equals(respuestaUsuario) ? 1 : 0;
    }

}
