package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarVFClasico extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    public ControladorEnviarVFClasico(Stage stagePrincipal, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(stagePrincipal, pantallaPrincipal, algoHoot);
        //this.opcionesJugador = new ArrayList<>();
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
