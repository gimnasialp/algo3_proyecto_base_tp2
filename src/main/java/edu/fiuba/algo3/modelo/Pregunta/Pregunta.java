package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public abstract class Pregunta {

    protected int idPregunta;
    protected String tema;
    protected String texto;
    protected String enunciado;
    protected ArrayList<String> opciones;
    protected Respuesta respuestaCorrecta;
    protected Resultado resultado;

    protected Pregunta(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones,
                       String texto) {
        this.idPregunta = idPregunta;
        this.tema = tema;
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.opciones = opciones;
        this.texto = texto;
        this.resultado = new Resultado();

    }

    public abstract Resultado responder(ArrayList<Respuesta> respuestas);


    public boolean mismoId(int id) {
        return (id == idPregunta);
    }

    public String obtenerTema() {
        return tema;
    }


    public String obtenerTextoRepuesta() {
        return texto;
    }

    public String obtenerEnunciado() {
        return enunciado;
    }

    public ArrayList<String> obtenerOpciones() {
        return opciones;
    }

    public abstract String ObtenerTipoPregunta();

    @Override
    public boolean equals(Object other) {
        return this.getClass().equals(other.getClass());
    }


}
