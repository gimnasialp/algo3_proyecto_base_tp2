package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ControladorCantidadJugadores implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxCantidadJugadores;

    public ControladorCantidadJugadores(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxCantidadJugadores) {
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxCantidadJugadores = comboBoxCantidadJugadores;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxCantidadJugadores.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert cantidadJugadorSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            cantidadJugadorSinSeleccionar.setHeaderText("No selecciono una cantidad de jugadores");
            cantidadJugadorSinSeleccionar.setContentText("Debe seleccionar la cantidad de jugadores para poder empezar el juego.");
            cantidadJugadorSinSeleccionar.show();

        } else {

            pantallaPrincipal.setCentro(new VistaPedirNombreJugadores(stage, pantallaPrincipal, Integer.parseInt(seleccion)));

        }


    }
}
