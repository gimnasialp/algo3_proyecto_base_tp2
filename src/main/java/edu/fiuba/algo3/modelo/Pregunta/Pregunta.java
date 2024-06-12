package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public abstract class Pregunta {

    protected String enunciado;
    protected ArrayList<String> opciones;
    protected Respuesta respuestaCorrecta;

    public Pregunta(String enunciado, ArrayList<String> opciones, Respuesta respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public abstract Resultado responder(ArrayList<Respuesta> respuestas);
}