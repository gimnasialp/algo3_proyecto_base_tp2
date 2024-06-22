package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;

public class MultipleChoicePenalidadParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoicePenalidadParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaMultipleChoiceConPenalidad parsearRespuesta(String respuesta) {
        return new RespuestaMultipleChoiceConPenalidad(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
