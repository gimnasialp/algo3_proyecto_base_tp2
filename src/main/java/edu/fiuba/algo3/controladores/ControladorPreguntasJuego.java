package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Excepciones.PuntajeMaximoSuperadoException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.Resultado;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.GestorVistasPreguntas;
import edu.fiuba.algo3.vista.vistas.VistaGanador;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import edu.fiuba.algo3.vista.vistas.VistaTurnoJugadorActual;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ControladorPreguntasJuego {

    protected Stage stage;
    protected PantallaPrincipal contenedorPrincipal;
    protected AlgoHoot algoHoot;
    protected Partida partidaActual;
    private Resultado resultado;
    private boolean juegoFinalizado;

    public ControladorPreguntasJuego(Stage stage, PantallaPrincipal contenedorPrincipal, AlgoHoot algoHoot) {
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
        this.algoHoot = algoHoot;
        this.juegoFinalizado = false;
        this.partidaActual = algoHoot.obtenerPartidaActiva();
    }

    protected void definirSiguienteVista(Respuesta respuestaDeUnJugador) {
        System.out.println(respuestaDeUnJugador);
        sumarPuntos(respuestaDeUnJugador);
        if(ultimoJugadorRespuesta()){
            if (juegoTermino()) {
                Jugador ganador = algoHoot.obtenerPartidaActiva().jugadorConMasPuntos();
                contenedorPrincipal.setCentro(new VistaGanador(stage, contenedorPrincipal, ganador));
            }else{

                algoHoot.obtenerPartidaActiva().avanzoConSiguienteJugador();
                contenedorPrincipal.setCentro(new VistaGeneralPartida(stage, contenedorPrincipal, algoHoot));
            }
        } else {
            algoHoot.obtenerPartidaActiva().avanzoConSiguienteJugador();
            contenedorPrincipal.setCentro(new VistaTurnoJugadorActual(stage, contenedorPrincipal, algoHoot));
        }

    }

    private void sumarPuntos(Respuesta respuestaJugador) {
        algoHoot.obtenerPartidaActiva().agregarRespuesta(respuestaJugador);

    }

    private boolean ultimoJugadorRespuesta() {
        List<Jugador> jugadores = partidaActual.getJugadores();
        Jugador jugadorActual = partidaActual.obtenerJugadorActivo();

        // Verificar si la lista de jugadores no está vacía
        if (!jugadores.isEmpty()) {
            Jugador ultimoJugador = jugadores.get(jugadores.size() - 1); // Obtener el último jugador en la lista

            // Comparar si el jugador actual es el último jugador en la lista
            if (ultimoJugador.equals(jugadorActual)) {
                return true;
            }
        }

        return false;
    }


    private boolean juegoTermino() {
        try {
            algoHoot.proximaPartida();

        } catch (PuntajeMaximoSuperadoException e) {
            juegoFinalizado = true;
        }

        if (juegoFinalizado) {
            return true;
        } else {
            return false;
        }
    }

}
