package edu.fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    protected String enunciado;
    protected List<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected String respuestaFormato;

    public List<Integer> responder(List<Respuesta> respuestasUsuario) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuesta : respuestasUsuario) {
            puntos.add(respuestaCorrecta.evaluar(respuesta));
        }
        return puntos;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public List<String> getOpciones() { return this.opciones; }

    public boolean permiteMultiplicadores() {
        return respuestaCorrecta.permiteMultiplicadores();
    }

    public boolean permiteExclusividad() {
        return respuestaCorrecta.permiteExclusividad();
    }

    public Respuesta respuestaIncorrecta() {
        return respuestaCorrecta.respuestaIncorrecta();
    }

    public String respuestaCorrecta() {
        return respuestaFormato;
    }
}
