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
    private AlgoHoot algoHoot;

    public ControladorAccederPregunta(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.algoHoot = algoHoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        pantallaPrincipal.setCentro(GestorVistasPreguntas.CrearVistaDePregunta(algoHoot, stage, pantallaPrincipal));
    }


}
