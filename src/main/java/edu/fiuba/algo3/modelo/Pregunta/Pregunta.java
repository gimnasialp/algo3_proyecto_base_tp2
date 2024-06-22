package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class Pregunta {

    private int idPregunta;
    private String tema;
    private String tipo;
    private String enunciado;
    private ArrayList<String> opciones;
    private String textoRespuesta;
    private Respuesta respuestaCorrecta;

    public Pregunta(int idPregunta, String tema, String tipo, String enunciado,
                    ArrayList<String>opciones, String textoRespuesta, Respuesta respuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.tema = tema;
        this.tipo = tipo;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.textoRespuesta = textoRespuesta;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta : respuestas) {
            resultado.agregarPuntos(respuesta.comparar(this.respuestaCorrecta));
        }

        return resultado;
    }
}
