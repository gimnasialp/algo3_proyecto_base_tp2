package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ControladorLimitePreguntas implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxLimitePreguntas;

    public ControladorLimitePreguntas(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxLimitePreguntas){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxLimitePreguntas = comboBoxLimitePreguntas;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxLimitePreguntas.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert cantidadPreguntasSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            cantidadPreguntasSinSeleccionar.setHeaderText("No selecciono una cantidad de preguntas");
            cantidadPreguntasSinSeleccionar.setContentText("Debe seleccionar un limite de Preguntas para poder empezar a jugar.");
            cantidadPreguntasSinSeleccionar.show();

        } else {
            pantallaPrincipal.setCentro(null);

        }

    }
}
