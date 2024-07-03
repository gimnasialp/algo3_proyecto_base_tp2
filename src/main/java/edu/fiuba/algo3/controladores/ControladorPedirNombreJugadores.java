package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaPedirLimite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorPedirNombreJugadores implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ArrayList<TextField> nombreJugadores;

    public ControladorPedirNombreJugadores(Stage stage, PantallaPrincipal pantallaPrincipal, ArrayList<TextField> nombres){
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.nombreJugadores = nombres;

    }


    private boolean validarDatosIngresados(){
        for (TextField textField : nombreJugadores) {
                String nombre = textField.getText();
            if (nombre.isEmpty()|| nombre.isBlank()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(validarDatosIngresados()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de validación");
            alerta.setHeaderText("Nombre de jugador vacío");
            alerta.setContentText("Por favor, ingrese un nombre para cada jugador.");
            alerta.showAndWait();
        }else{
            ArrayList<Jugador> jugadores = new ArrayList<>();
            for (TextField textField : nombreJugadores) {
                String nombre = textField.getText();
                jugadores.add(new Jugador(nombre));
            }

            pantallaPrincipal.setCentro(new VistaPedirLimite("imagenVistaAyuda.jpg", stage,pantallaPrincipal,jugadores));

        }

    }
}
