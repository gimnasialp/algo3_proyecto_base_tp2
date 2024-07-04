package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.LimitadorPorPuntos;
import edu.fiuba.algo3.modelo.Limite.Limite;
import edu.fiuba.algo3.modelo.Limite.LimiteFinalPreguntas;
import edu.fiuba.algo3.modelo.Limite.PuntosDefinidosDecorator;
import edu.fiuba.algo3.modelo.MezcladorPreguntas;
import edu.fiuba.algo3.modelo.MezcladorPreguntasSegunTema;
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

public class ControladorLimitePuntuacion implements EventHandler<ActionEvent> {
    private Stage stage;
    private PantallaPrincipal pantallaPrincipal;
    private ComboBox<String> comboBoxLimitesPuntuacion;
    private ArrayList<Jugador> jugadores;
    private AlgoHoot algoHoot;

    public ControladorLimitePuntuacion(Stage stage, PantallaPrincipal pantallaPrincipal, ComboBox<String> comboBoxLimitesPuntuacion, ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.stage = stage;
        this.pantallaPrincipal = pantallaPrincipal;
        this.comboBoxLimitesPuntuacion = comboBoxLimitesPuntuacion;
    }

    private void crearAlgohoot(int limitePuntuacion) {

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

        //Las sig 2 lineas son para mezclar las preguntas de la lista
        MezcladorPreguntas mezcladorPreguntas = new MezcladorPreguntasSegunTema(preguntas);
        ArrayList<Pregunta> preguntasMezcladas = mezcladorPreguntas.mezclarPreguntas();

        Limite limite = new LimitadorPorPuntos(preguntasMezcladas);
        Limite limiteDecorator = new PuntosDefinidosDecorator(limite, preguntasMezcladas, limitePuntuacion);
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limiteDecorator);
        algoHoot.proximaPartida();
        algoHoot.obtenerPartidaActiva().avanzoConSiguienteJugador();
        this.algoHoot = algoHoot;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxLimitesPuntuacion.getValue();
        int limite = Integer.parseInt(seleccion);
        if (seleccion == null || seleccion.isEmpty()) {
            Alert limitePuntuacionSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            limitePuntuacionSinSeleccionar.setHeaderText("No selecciono un limite de puntacion ");
            limitePuntuacionSinSeleccionar.setContentText("Debe seleccionar un limite de puntacion para poder empezar a jugar. ");
            limitePuntuacionSinSeleccionar.show();

        } else {
            crearAlgohoot(limite);
            pantallaPrincipal.setCentro(new VistaGeneralPartida(stage, pantallaPrincipal, algoHoot));

        }

    }
}
