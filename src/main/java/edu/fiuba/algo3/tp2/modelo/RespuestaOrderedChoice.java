package edu.fiuba.algo3.tp2.modelo;

import java.util.Collections;
import java.util.List;

public class RespuestaOrderedChoice implements Respuesta{

    private final List<Integer> respuesta;

    public RespuestaOrderedChoice(List<Integer> respuesta) {
        this.respuesta = respuesta;
    }

    public boolean equals(RespuestaOrderedChoice otraRespuesta) {
        return otraRespuesta.equals(respuesta);
    }

    private boolean equals(List<Integer> otraRespuesta) {
        return respuesta.equals(otraRespuesta);
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario) {
        try {
            return this.equals((RespuestaOrderedChoice) respuestaUsuario) ? 1 : 0;
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
        return new RespuestaOrderedChoice(Collections.emptyList());
    }


}
