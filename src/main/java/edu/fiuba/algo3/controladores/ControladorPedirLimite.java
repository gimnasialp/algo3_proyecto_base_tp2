package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaLimitePreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorPedirLimite implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxTiposDeLimites;
    private ArrayList<Jugador> jugadores;

    public ControladorPedirLimite(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxTiposDeLimites, ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
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
                    pantallaPrincipal.setCentro(new VistaLimitePreguntas(stage, pantallaPrincipal, jugadores));
                    break;
                case "Cantidad de Preguntas":
                    pantallaPrincipal.setCentro(new VistaLimitePreguntas(stage, pantallaPrincipal, jugadores));
                    break;
            }

        }

    }
}
