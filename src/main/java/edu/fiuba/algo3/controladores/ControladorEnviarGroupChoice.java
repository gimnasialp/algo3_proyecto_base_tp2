package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerGroupChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarGroupChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {
    private List<String> nombresGrupos;
    private List<String> opcionesSeleccionadas;
    private List<SpinnerGroupChoice> spinners;

    public ControladorEnviarGroupChoice(List<String> nombresGrupos, Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(stage, pantallaPrincipal, algoHoot);
        this.nombresGrupos = nombresGrupos;
        this.opcionesSeleccionadas = new ArrayList<>();
        this.spinners = new ArrayList<>();
    }

    public void agregarSpinnersGrupo(List<SpinnerGroupChoice> spinners) {
        this.spinners.addAll(spinners);
    }

    public void manejarRespuestas() {
        ArrayList<Integer> grupoA = new ArrayList<>();
        ArrayList<Integer> grupoB = new ArrayList<>();

        for (SpinnerGroupChoice spinnerGroupChoice : spinners) {
            String grupo = spinnerGroupChoice.getGrupoOpcion();
            String opcion = spinnerGroupChoice.getOpcionSpinner();
            int indiceOpcion = Integer.parseInt(opcion.split(" ")[1]); // Asume que la opción sigue el formato "Opcion X"

            if (grupo.equals(nombresGrupos.get(0))) {
                grupoA.add(indiceOpcion);
            } else {
                grupoB.add(indiceOpcion);
            }
        }

        RespuestaGroupChoice respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        definirSiguienteVista(respuesta);
    }





    @Override
    public void handle(ActionEvent event) {
        if (spinners.isEmpty()) {
            Alert noRespondio = new Alert(Alert.AlertType.ERROR);
            noRespondio.setHeaderText("No respondio alguna opcion");
            noRespondio.setContentText("Debe de responder como minimo una opcion!");
            noRespondio.show();
        } else {
            manejarRespuestas();
        }
    }

}

