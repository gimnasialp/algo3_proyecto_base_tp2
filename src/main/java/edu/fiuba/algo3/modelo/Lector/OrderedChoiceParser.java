package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;

public class OrderedChoiceParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public OrderedChoiceParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public RespuestaOrderedChoice parsearRespuesta(String respuesta) {
        return new RespuestaOrderedChoice(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
