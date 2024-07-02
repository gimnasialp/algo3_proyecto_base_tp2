package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VP.VistaMultipleChoiceClasico;
import edu.fiuba.algo3.vista.vistas.VP.VistaOrderedChoice;
import edu.fiuba.algo3.vista.vistas.VistaTurnoJugadorActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        pantallaPrincipal.setCentro(new VistaTurnoJugadorActual(stage, pantallaPrincipal, algoHoot));
    }
}
