package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControladorEnviarOrderedChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    private List<SpinnerOrderedChoice> opcionesSeleccionadas;
    private ArrayList<Integer> respuestas;

    public ControladorEnviarOrderedChoice(Stage stagePrincipal, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(stagePrincipal, pantallaPrincipal, algoHoot);
        this.opcionesSeleccionadas = new ArrayList<>();
        this.respuestas = new ArrayList<>();
    }

    public void agregarOpcionesSeleccionadas(List<SpinnerOrderedChoice> opcionesSeleccionadas) {
        this.opcionesSeleccionadas = opcionesSeleccionadas;
        procesarRespuestas();
    }

    private void procesarRespuestas() {
        for (SpinnerOrderedChoice spinnerOrderedChoice : opcionesSeleccionadas) {
            respuestas.add(spinnerOrderedChoice.getNumeroOrden());
        }
    }

    @Override
    public void handle(ActionEvent event) {
        if (seRepitenOpcionesSeleccionadas()) {
            Alert noRespondio = new Alert(Alert.AlertType.ERROR);
            noRespondio.setHeaderText("Opciones repetidoas!");
            noRespondio.setContentText("No puede repetir opciones!");
            noRespondio.show();
            this.respuestas = new ArrayList<>();
        } else {
            RespuestaOrderedChoice respuestaDeUnJugador = new RespuestaOrderedChoice(respuestas);
            definirSiguienteVista(respuestaDeUnJugador);
        }

    }
    private boolean seRepitenOpcionesSeleccionadas() {
        int contadorPos1 = 0, contadorPos2 = 0;
        int contadorPos3 = 0, contadorPos4 = 0;
        int contadorPos5 = 0;

        ArrayList<Integer> listaAux = new ArrayList<>();
        for(SpinnerOrderedChoice opcion : opcionesSeleccionadas){
            listaAux.add(opcion.getNumeroOrden());
        }
        for(int orden : listaAux){
            if(orden == 1)
                contadorPos1++;
            if(orden == 2)
                contadorPos2 ++;
            if(orden == 3)
                contadorPos3 ++;
            if(orden == 4)
                contadorPos4 ++;
            if(orden == 5)
                contadorPos5 ++;
        }
        return hayMasDeUnaOpcionEnElMismoLugar(contadorPos1, contadorPos2, contadorPos3, contadorPos4, contadorPos5);
    }

    private boolean hayMasDeUnaOpcionEnElMismoLugar(int contadorPos1, int contadorPos2, int contadorPos3, int contadorPos4, int contadorPos5) {
        return (contadorPos1 > 1) || (contadorPos2 > 1) || (contadorPos3 > 1) || (contadorPos4 > 1) || (contadorPos5 > 1);
    }
}
