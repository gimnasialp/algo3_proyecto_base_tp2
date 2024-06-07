package edu.fiuba.algo3.tp2.modelo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.google.common.collect.Sets;

public class RespuestaMultipleChoice implements Respuesta {

    private final Set<Integer> opciones;
    private Puntaje puntaje;

    public RespuestaMultipleChoice(Set<Integer> opciones) {
        this.opciones = opciones;
    }

    public static RespuestaMultipleChoice ConPuntaje(Set<Integer> opciones, Puntaje puntaje) {
        RespuestaMultipleChoice miRespuestaMC = new RespuestaMultipleChoice(opciones);
        miRespuestaMC.puntaje = puntaje;
        return miRespuestaMC;
    }

    public Set<Integer> intersection(RespuestaMultipleChoice respuesta) {
        return respuesta.intersection(opciones);
    }

    private Set<Integer> intersection(Set<Integer> opciones) {
        return Sets.intersection(this.opciones, opciones);
    }

    public Integer size() {
        return opciones.size();
    }

    @Override
    public Integer evaluar(Respuesta respuestaUsuario) {
        try {
            RespuestaMultipleChoice respuestaUsuarioCasteada = (RespuestaMultipleChoice) respuestaUsuario;
            int aciertos = this.intersection(respuestaUsuarioCasteada).size();
            int errores = respuestaUsuarioCasteada.size() - aciertos;
            return puntaje.puntuar(aciertos, errores);
        } catch (RuntimeException e) {
            throw new RespuestaNoCompatibleException();
        }
    }

    @Override
    public boolean permiteMultiplicadores() {
        return puntaje.permiteMultiplicadores();
    }

    @Override
    public boolean permiteExclusividad() {
        return puntaje.permiteExclusividad();
    }

    @Override
    public Respuesta respuestaIncorrecta() {
        return new RespuestaMultipleChoice(new HashSet<>());
    }
}
