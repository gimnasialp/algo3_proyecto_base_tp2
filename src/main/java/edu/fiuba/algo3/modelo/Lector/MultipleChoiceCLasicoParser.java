package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceComun;

public class MultipleChoiceCLasicoParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoiceCLasicoParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaMultipleChoiceComun parsearRespuesta(String respuesta) {
        return new RespuestaMultipleChoiceComun(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
