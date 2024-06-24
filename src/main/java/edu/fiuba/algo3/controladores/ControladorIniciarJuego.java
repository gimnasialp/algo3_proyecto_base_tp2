package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
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
        pantallaPrincipal.setCentro(new VistaPedirNombreJugadores(stage,pantallaPrincipal));
    }

}
