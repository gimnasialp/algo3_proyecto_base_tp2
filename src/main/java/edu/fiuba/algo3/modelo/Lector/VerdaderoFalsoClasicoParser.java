package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalsoClasico;

public class VerdaderoFalsoClasicoParser implements ParserRespuesta {
    private ParserRespuestaUnica parserRespuesta;

    public VerdaderoFalsoClasicoParser() {
        this.parserRespuesta = new ParserRespuestaUnica();
    }

    public RespuestaVerdaderoFalsoClasico parsearRespuesta(String respuesta) {
        return new RespuestaVerdaderoFalsoClasico(this.parserRespuesta.parsearOpcionRespuesta(respuesta));
    }
}
