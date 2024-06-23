package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public class Responder {
    private  Modificador modificador;
    private  List<Respuesta> respuestaDeJugador;
    private  Jugador jugador;

    public Responder(Jugador jugador, List<Respuesta> respuestaDeJugador, Modificador multiplicador) {
        this.jugador= jugador;
        this.respuestaDeJugador= respuestaDeJugador;
        this.modificador=multiplicador;
    }

    public List<Respuesta> getRespuestaDeJugador() {
        return respuestaDeJugador;
    }
}
