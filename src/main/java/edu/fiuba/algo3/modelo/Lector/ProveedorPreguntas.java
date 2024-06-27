package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.ArrayList;

public interface ProveedorPreguntas {

    public ArrayList<Pregunta> obtenerPreguntasDe(String nombreProveedor);

}