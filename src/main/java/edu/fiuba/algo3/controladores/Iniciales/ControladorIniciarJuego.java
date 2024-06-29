package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VP.VistaGroupChoice;
import edu.fiuba.algo3.vista.vistas.VP.VistaOrderedChoice;
import edu.fiuba.algo3.vista.vistas.VP.VistaVFClasico;
import edu.fiuba.algo3.vista.vistas.VP.VistaVFPenalidad;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import edu.fiuba.algo3.vista.vistas.VistaPedirCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;

    public ControladorIniciarJuego(Stage stage, PantallaPrincipal pantallaPrincipal){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        pantallaPrincipal.setCentro(new VistaPedirCantidadJugadores(stage,pantallaPrincipal));

    }


}
