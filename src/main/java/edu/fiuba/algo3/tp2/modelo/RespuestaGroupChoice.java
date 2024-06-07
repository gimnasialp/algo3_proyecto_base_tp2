package edu.fiuba.algo3.tp2.modelo;

import java.util.HashSet;
import java.util.Set;

public class RespuestaGroupChoice implements Respuesta{

    private final Set<Integer> grupoA;
    private final Set<Integer> grupoB;

    public RespuestaGroupChoice(Set<Integer> grupoA, Set<Integer> grupoB){
        this.grupoA = grupoA;
        this.grupoB = grupoB;
    }

    public boolean equals(RespuestaGroupChoice otraRespuesta) {
        return otraRespuesta.equals(grupoA, grupoB);
    }

    private boolean equals(Set<Integer> grupoA, Set<Integer> grupoB) {
        return this.grupoA.equals(grupoA) && this.grupoB.equals(grupoB);
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario){
        try {
            return this.equals((RespuestaGroupChoice) respuestaUsuario) ? 1 : 0;
        } catch (RuntimeException e) {
            throw new RespuestaNoCompatibleException();
        }
    }

    @Override
    public boolean permiteMultiplicadores() {
        return false;
    }

    @Override
    public boolean permiteExclusividad() {
        return true;
    }

    @Override
    public Respuesta respuestaIncorrecta() {
        return new RespuestaGroupChoice(new HashSet<>(), new HashSet<>());
    }

}
