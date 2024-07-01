package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import edu.fiuba.algo3.vista.vistas.VistaTurnoJugadorActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ControladorGeneralPartida implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private AlgoHoot algoHoot;

    public ControladorGeneralPartida(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.algoHoot = algoHoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (Jugador jugador : algoHoot.obtenerPartidaActiva().getJugadores()) {
            Partida partidaActiva = algoHoot.obtenerPartidaActiva();
            pantallaPrincipal.setCentro(new VistaTurnoJugadorActual(stage, pantallaPrincipal, partidaActiva));

        }
        pantallaPrincipal.setCentro(new VistaGeneralPartida(stage, pantallaPrincipal, algoHoot));
    }
}
