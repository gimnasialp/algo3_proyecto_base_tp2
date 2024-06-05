package edu.fiuba.algo3.modelo.Preguntas.VoF;

public class OpcionIncorrectaVerdaderoFalsoClasico {
    private String textoRespuesta;

    public OpcionIncorrectaVerdaderoFalsoClasico (boolean respuestaInCorrecta) {
        textoRespuesta = respuestaInCorrecta?"Verdadero":"Falso";
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }
}
