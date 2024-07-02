package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorLimitePreguntas implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxLimitePreguntas;
    private ArrayList<Jugador> jugadores;
    private AlgoHoot algoHoot;

    public ControladorLimitePreguntas(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxLimitePreguntas,ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxLimitePreguntas = comboBoxLimitePreguntas;

    }
    private void crearAlgohoot(String limitePregunta){
        HashMap<String, Parser> tiposPreguntas = new HashMap<>();
        tiposPreguntas.put("verdadero falso simple", new VerdaderoFalsoClasicoParser());
        tiposPreguntas.put("verdadero falso penalidad", new VerdaderoFalsoConPenalidadParser());
        tiposPreguntas.put("multiple choice simple", new MultipleChoiceCLasicoParser());
        tiposPreguntas.put("multiple choice puntaje parcial", new MultipleChoiceParcialParser());
        tiposPreguntas.put("multiple choice penalidad", new MultipleChoicePenalidadParser());
        tiposPreguntas.put("ordered choice", new OrderedChoiceParser());
        tiposPreguntas.put("group choice", new GroupChoiceParser());

        ProveedorJsonPreguntas proveedor = new ProveedorJsonPreguntas(tiposPreguntas);
        ArrayList<Pregunta> preguntas = proveedor.obtenerPreguntasDe("preguntas.json");

        Limite limite = new LimiteFinalPreguntas(preguntas);
        AlgoHoot algoHoot = new AlgoHoot(jugadores,limite);
        algoHoot.proximaPartida();
        algoHoot.obtenerPartidaActiva().avanzoConSiguienteJugador();
        this.algoHoot = algoHoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String seleccion = comboBoxLimitePreguntas.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert cantidadPreguntasSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            cantidadPreguntasSinSeleccionar.setHeaderText("No selecciono una cantidad de preguntas");
            cantidadPreguntasSinSeleccionar.setContentText("Debe seleccionar un limite de Preguntas para poder empezar a jugar.");
            cantidadPreguntasSinSeleccionar.show();
        } else {
            crearAlgohoot(seleccion);
            pantallaPrincipal.setCentro(new VistaGeneralPartida(stage, pantallaPrincipal,algoHoot));

        }

    }
}
