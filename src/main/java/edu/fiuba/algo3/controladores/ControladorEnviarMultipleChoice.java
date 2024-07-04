package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceClasico;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorEnviarMultipleChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {
    private ArrayList<Integer> opcionesSeleccionadas;


    public ControladorEnviarMultipleChoice(Stage stagePrincipal, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(stagePrincipal, pantallaPrincipal, algoHoot);
        this.opcionesSeleccionadas = new ArrayList<>();
    }

    public void agregarOpcion(int indice) {
        if (!opcionesSeleccionadas.contains(indice)) {
            opcionesSeleccionadas.add(indice);
        }
    }

    public void eliminarOpcion(int indice) {
        opcionesSeleccionadas.remove(Integer.valueOf(indice));
    }

    @Override
    public void handle(ActionEvent event) {
        if (opcionesSeleccionadas.isEmpty()) {
            Alert noRespondio = new Alert(Alert.AlertType.ERROR);
            noRespondio.setHeaderText("No respondió alguna opción");
            noRespondio.setContentText("Debe responder como mínimo una opción!");
            noRespondio.show();
        } else {
            System.out.println(opcionesSeleccionadas);
            RespuestaMultipleChoiceClasico respuestaDeUnJugador = new RespuestaMultipleChoiceClasico(new ArrayList<>(opcionesSeleccionadas));
            definirSiguienteVista(respuestaDeUnJugador);
        }
    }

}
