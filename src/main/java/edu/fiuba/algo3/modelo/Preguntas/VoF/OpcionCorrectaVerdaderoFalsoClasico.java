package edu.fiuba.algo3.modelo.Preguntas.VoF;

public class OpcionCorrectaVerdaderoFalsoClasico {
    private String textoRespuesta;


    public OpcionCorrectaVerdaderoFalsoClasico(boolean respuestaCorrecta) {
        textoRespuesta = respuestaCorrecta?"Verdadero":"Falso";
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }
}
