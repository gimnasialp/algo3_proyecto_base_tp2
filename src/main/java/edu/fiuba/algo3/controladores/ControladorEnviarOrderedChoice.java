package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorEnviarOrderedChoice implements EventHandler<ActionEvent> {
    private PantallaPrincipal principal;
    private Stage stage;
    private ArrayList<SpinnerOrderedChoice> opcionesVista;
    //private HashMap<Integer, Integer> opcionesOrdenHash;
    private ArrayList<Integer> opcionesJugador;

    public ControladorEnviarOrderedChoice(Stage escenario, PantallaPrincipal pantallaPrincipal, Partida partida) {
        this.principal = pantallaPrincipal;
        this.stage = escenario;
        this.opcionesJugador = new ArrayList<>();
    }

    public void agregarOpcionesSeleccionadas(ArrayList<SpinnerOrderedChoice> opciones) {
        opcionesVista = opciones;
        for (SpinnerOrderedChoice spinner : opcionesVista) {
            opcionesJugador.add(spinner.getValue()); // Obtener el valor seleccionado del Spinner y agregarlo a la lista
        }
    }
/*
    public void agregarOpcionesCorrectas(ArrayList<Integer> opcionesCorrectas) {
        for (Integer opcion : opcionesCorrectas) {
            opcionesOrdenHash.put(opcion, opcion);
        }
    }
*/
    @Override
    public void handle(ActionEvent actionEvent) {
        if (seRepitenOpcionesSeleccionadas()) {
            Alert repiteoOrden = new Alert(Alert.AlertType.ERROR);
            repiteoOrden.setHeaderText("Se repitieron posiciones");
            repiteoOrden.setContentText("Se deben elegir posiciones de orden distintas para cada opcion!");
            repiteoOrden.show();
        } else {
            RespuestaOrderedChoice respuestaDeUnJugador = new RespuestaOrderedChoice(opcionesJugador);
            //definirSiguienteVista(respuestaDeUnJugador);
        }
    }

    private boolean seRepitenOpcionesSeleccionadas() {
        int contadorPos1 = 0, contadorPos2 = 0;
        int contadorPos3 = 0, contadorPos4 = 0;
        int contadorPos5 = 0;

        ArrayList<Integer> listaAux = new ArrayList<>();
        for (SpinnerOrderedChoice opcion : opcionesVista) {
            listaAux.add(opcion.getNumeroOrden());
        }
        for (int orden : listaAux) {
            if (orden == 1)
                contadorPos1++;
            if (orden == 2)
                contadorPos2++;
            if (orden == 3)
                contadorPos3++;
            if (orden == 4)
                contadorPos4++;
            if (orden == 5)
                contadorPos5++;
        }
        return hayMasDeUnaOpcionEnElMismoLugar(contadorPos1, contadorPos2, contadorPos3, contadorPos4, contadorPos5);
    }

    private boolean hayMasDeUnaOpcionEnElMismoLugar(int contadorPos1, int contadorPos2, int contadorPos3, int contadorPos4, int contadorPos5) {
        return (contadorPos1 > 1) || (contadorPos2 > 1) || (contadorPos3 > 1) || (contadorPos4 > 1) || (contadorPos5 > 1);
    }

}
