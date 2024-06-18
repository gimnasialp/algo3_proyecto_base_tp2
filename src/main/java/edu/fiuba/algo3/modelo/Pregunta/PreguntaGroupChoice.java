package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaGroupChoice implements Pregunta {

    private int idPregunta;
    private String tema;
    private String textoRepuesta;
    private String enunciado;
    private ArrayList<String> opciones;
    private Respuesta respuestaCorrecta;

    public PreguntaGroupChoice(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String> opciones, String textoRespuesta) {
        this.idPregunta = idPregunta;
        this.tema = tema;
        this.textoRepuesta = textoRespuesta;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {
        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas){
            int puntos = 0;
            if (respuestaCorrecta.comparar(respuesta)){
                puntos += 1;
            }
            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

    @Override
    public boolean mismoId(int id) {
        return (id == idPregunta);
    }
}
