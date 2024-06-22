package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;

public class GroupChoiceParser implements ParserRespuesta {
    private ParserGruposRespuesta parserRespuesta;

    public GroupChoiceParser() {
        this.parserRespuesta = new ParserGruposRespuesta();
    }

    public RespuestaGroupChoice parsearRespuesta(String respuesta) {
        return new RespuestaGroupChoice(this.parserRespuesta.parsearGruposRespuesta(respuesta));
    }
}
