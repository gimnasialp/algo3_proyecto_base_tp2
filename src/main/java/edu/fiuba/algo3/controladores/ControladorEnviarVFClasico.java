package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ControladorEnviarVFClasico extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    private RespuestaVerdaderoFalso respuesta;

    public ControladorEnviarVFClasico(Stage stagePrincipal, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot, RespuestaVerdaderoFalso respuestaJugador) {
        super(stagePrincipal, pantallaPrincipal, algoHoot);
        this.respuesta = respuestaJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Respuesta");
        alerta.setHeaderText("Respuesta de la pregunta");
        alerta.setContentText(algoHoot.obtenerPartidaActiva().obtenerPreguntaActual().obtenerTextoRepuesta());
        alerta.showAndWait();
        definirSiguienteVista(respuesta);
    }
}
