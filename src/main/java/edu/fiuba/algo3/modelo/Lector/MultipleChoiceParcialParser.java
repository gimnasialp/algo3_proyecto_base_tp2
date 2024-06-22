package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPuntajeParcial;

public class MultipleChoiceParcialParser implements ParserRespuesta {
    private ParserListaRespuesta parserRespuesta;

    public MultipleChoiceParcialParser() {
        this.parserRespuesta = new ParserListaRespuesta();
    }

    public Respuesta parsearRespuesta(String respuesta) {
        return new RespuestaMultipleChoiceConPuntajeParcial(this.parserRespuesta.parsearListaRespuesta(respuesta));
    }
}
