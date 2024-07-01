package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.GestorVistasPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorAccederPregunta implements EventHandler<ActionEvent> {

    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private Partida partidaActual;

    public ControladorAccederPregunta(Stage stage, PantallaPrincipal pantallaPrincipal,Partida partidaActual) {
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.partidaActual = partidaActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        pantallaPrincipal.setCentro(GestorVistasPreguntas.CrearVistaDePregunta(partidaActual, stage, pantallaPrincipal));
    }


}
