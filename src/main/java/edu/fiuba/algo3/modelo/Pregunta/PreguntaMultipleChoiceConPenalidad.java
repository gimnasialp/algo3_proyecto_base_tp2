package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.ArrayList;

public class PreguntaMultipleChoiceConPenalidad implements Pregunta {

    private final int idPregunta;
    private final String tema;
    private final String textoRepuesta;
    private final String enunciado;
    private final ArrayList<String> opciones;
    private final Respuesta respuestaCorrecta;

    public PreguntaMultipleChoiceConPenalidad(int idPregunta, String tema, String enunciado, Respuesta respuestaCorrecta, ArrayList<String>opciones, String textoRespuesta) {
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

        for (Respuesta respuesta: respuestas) {

            RespuestaMultipleChoiceConPenalidad respuestaJugador = (RespuestaMultipleChoiceConPenalidad) respuesta;

            int puntos = 0;

            puntos += respuestaJugador.opcionesCorrectas(this.respuestaCorrecta);
            puntos -= respuestaJugador.opcionesIncorrectas(this.respuestaCorrecta);

            resultado.agregarPuntos(puntos);
        }

        return resultado;
    }

    @Override
    public boolean mismoId(int id) {
        return (id == idPregunta);
    }

}