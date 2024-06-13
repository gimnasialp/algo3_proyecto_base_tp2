package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoConPenalidad implements Pregunta {
    private int idPregunta;
    private String tema;
    private String textoRepuesta;
    private String enunciado;
    private ArrayList<String> opciones;
    private Respuesta respuestaCorrecta;
    public PreguntaVerdaderoFalsoConPenalidad(int idPregunta,String tema, String enunciadoPregunta,
                                         Respuesta respuestaCorrecta,ArrayList<String>opciones,String textoRespuesta) {

        this.enunciado = enunciadoPregunta;
        this.opciones = opciones;
        this.respuestaCorrecta=respuestaCorrecta;
        this.idPregunta = idPregunta;
        this.tema = tema;
        this.textoRepuesta = textoRespuesta;
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        Resultado resultado = new Resultado();

        for (Respuesta respuesta: respuestas) {
            int puntos = 0;
            if (respuesta.comparar(this.respuestaCorrecta)){
                puntos += 1;
            } else {
                puntos -= 1;
            }
            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

}
