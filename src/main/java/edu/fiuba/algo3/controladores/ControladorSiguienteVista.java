package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaPedirCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorSiguienteVista  implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;

    public ControladorSiguienteVista(Stage stage, PantallaPrincipal pantallaPrincipal){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
    }

    public void cambiarVista(StackPane vista){
        pantallaPrincipal.setCentro(vista);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //cambiarVista();
    }


}

