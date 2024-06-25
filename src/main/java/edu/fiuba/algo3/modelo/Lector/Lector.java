package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import java.util.ArrayList;

public interface Lector {
    ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException;


}
