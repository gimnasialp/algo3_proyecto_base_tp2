package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorReiniciarJuego implements EventHandler<ActionEvent> {
    private PantallaPrincipal principal;
    private Stage stage;

    public ControladorReiniciarJuego(Stage stage, PantallaPrincipal contenedorPrincipal) {
        this.stage = stage;
        this.principal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent event) {
        principal.setCentro(new VistaInicial(stage,principal));
    }
}
