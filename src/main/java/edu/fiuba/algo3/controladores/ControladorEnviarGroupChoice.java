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
import java.util.HashMap;
import java.util.List;

/*public class ControladorEnviarGroupChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {
    private final HashMap<String, ArrayList<String>> respuestasUsuario;
    ArrayList<SpinnerGroupChoice> spinnerGrupos;
    private final ArrayList<String> nombresGrupo;

    public ControladorEnviarGroupChoice(ArrayList<String> nombresGrupo, Stage stage, PantallaPrincipal contenedorPrincipal,AlgoHoot algoHoot) {
        super(stage, contenedorPrincipal, algoHoot);
        this.nombresGrupo = nombresGrupo;
        respuestasUsuario = new HashMap<>();
        respuestasUsuario.put(nombresGrupo.get(0), new ArrayList<>());
        respuestasUsuario.put(nombresGrupo.get(1), new ArrayList<>());
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        agregarOpcionesSeleccionadas(spinnerGrupos);
        RespuestaGroupChoice respuestaDeUnJugador = new RespuestaGroupChoice(nombresGrupo.get(0), respuestasUsuario.get(nombresGrupo.get(0)), nombresGrupo.get(1), respuestasUsuario.get(nombresGrupo.get(1)));
        definirSiguienteVista(respuestaDeUnJugador);
    }

    public void agregarSpinnersGrupo(ArrayList<SpinnerGroupChoice> spinnerGrupos) {
        this.spinnerGrupos = spinnerGrupos;
    }

    public void agregarOpcionesSeleccionadas(ArrayList<SpinnerGroupChoice> spinnersGrupo) {
        for (SpinnerGroupChoice spinner : spinnersGrupo) {
            respuestasUsuario.get(spinner.getGrupoOpcion()).add(spinner.getOpcionSpinner());
        }
    }

}*/

