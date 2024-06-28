package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import edu.fiuba.algo3.vista.vistas.VistaLimitePreguntas;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ControladorLimitePuntuacion implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxLimitesPuntuacion;

    public ControladorLimitePuntuacion(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxLimitesPuntuacion){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxLimitesPuntuacion = comboBoxLimitesPuntuacion;
    }



    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxLimitesPuntuacion.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert limitePuntuacionSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            limitePuntuacionSinSeleccionar.setHeaderText("No selecciono un limite de puntacion ");
            limitePuntuacionSinSeleccionar.setContentText("Debe seleccionar un limite de puntacion para poder empezar a jugar. ");
            limitePuntuacionSinSeleccionar.show();

        } else {
            pantallaPrincipal.setCentro(new VistaGeneralPartida(stage, pantallaPrincipal));

        }

    }
}
