package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.Puntaje.Puntaje;
import edu.fiuba.algo3.modelo.Puntaje.PuntajeNormal;

import java.util.Objects;

public class RespuestaVerdaderoFalsoClasico extends RespuestaVerdaderoFalso {
    public RespuestaVerdaderoFalsoClasico(Integer respuesta) {
        this.respuesta = respuesta;
        this.puntaje = new PuntajeNormal();
    }
}
