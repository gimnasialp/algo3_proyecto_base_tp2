package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControladorSiguienteVista  implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private StackPane vistaActual;

    public ControladorSiguienteVista(Stage stage, PantallaPrincipal pantallaPrincipal,StackPane vista){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.vistaActual = vista;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        pantallaPrincipal.setCentro(vistaActual);
    }


}

