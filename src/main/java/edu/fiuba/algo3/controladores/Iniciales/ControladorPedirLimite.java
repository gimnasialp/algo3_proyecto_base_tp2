package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaLimitePreguntas;
import edu.fiuba.algo3.vista.vistas.VistaLimitePuntacion;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ControladorPedirLimite implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxTiposDeLimites;

    public ControladorPedirLimite(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxTiposDeLimites){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxTiposDeLimites = comboBoxTiposDeLimites;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxTiposDeLimites.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert LimiteSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            LimiteSinSeleccionar.setHeaderText("No selecciono como desea que termine el juego.");
            LimiteSinSeleccionar.setContentText("Debe seleccionar una de las opciones establecidas.");
            LimiteSinSeleccionar.show();

        } else {
            switch (seleccion) {
                case "Puntos":
                    pantallaPrincipal.setCentro(new VistaLimitePuntacion(stage, pantallaPrincipal));
                    break;
                case "Cantidad de Preguntas":
                    pantallaPrincipal.setCentro(new VistaLimitePreguntas(stage, pantallaPrincipal));
                    break;
            }

        }

    }
}
