package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoConPenalidad;

public class VerdaderoFalsoConPenalidadParser implements ParserRespuesta {
    private ParserRespuestaUnica parserRespuesta;

    public VerdaderoFalsoConPenalidadParser() {
        this.parserRespuesta = new ParserRespuestaUnica();
    }

    public RespuestaVerdaderoFalsoConPenalidad parsearRespuesta(String respuesta) {
        return new RespuestaVerdaderoFalsoConPenalidad(this.parserRespuesta.parsearOpcionRespuesta(respuesta));
    }
}
