package edu.fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import com.google.common.collect.Sets;

public class RespuestaMultipleChoice {

    private final Set<Integer> opciones;

    public RespuestaMultipleChoice(Set<Integer> opciones) {
        this.opciones = opciones;
    }

    public Integer size() {
        return this.opciones.size();
    }

    public List<Integer> evaluar(RespuestaMultipleChoice respuestaUsuario) {
        Integer aciertos = this.intersection(respuestaUsuario).size();
        Integer errores = respuestaUsuario.size() - aciertos;
        return Arrays.asList(aciertos, errores);
    }

    public Set<Integer> intersection(RespuestaMultipleChoice respuesta) {
        return respuesta.intersection(this.opciones);
    }

    private Set<Integer> intersection(Set<Integer> opciones) {
        return Sets.intersection(this.opciones, opciones);
    }

}
