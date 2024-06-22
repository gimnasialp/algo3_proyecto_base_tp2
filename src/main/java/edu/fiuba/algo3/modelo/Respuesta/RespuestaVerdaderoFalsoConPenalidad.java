package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;
import edu.fiuba.algo3.modelo.Puntaje.PuntajePenalidad;

public class RespuestaVerdaderoFalsoConPenalidad extends RespuestaVerdaderoFalso {
    public RespuestaVerdaderoFalsoConPenalidad(Integer respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajePenalidad();
    }
}
