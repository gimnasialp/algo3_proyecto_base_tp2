package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaVerdaderoFalsoClasico implements Pregunta {

    private final int idPregunta;
    private final String tema;
    private final String textoRepuesta;
    private final String enunciado;
    private final ArrayList<String> opciones;
    private final Respuesta respuestaCorrecta;
    private Resultado resultado ;

    public PreguntaVerdaderoFalsoClasico(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String>opciones, String textoRespuesta) {
        this.idPregunta = idPregunta;
        this.tema = tema;
        this.textoRepuesta = textoRespuesta;
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        resultado = new Resultado();
    }

    @Override
    public Resultado responder(ArrayList<Respuesta> respuestas) {

        for (Respuesta respuesta: respuestas) {
            int puntos = 0;
            if (respuesta.comparar(this.respuestaCorrecta)){
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
