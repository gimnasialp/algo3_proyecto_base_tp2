package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Limite.*;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VistaGeneralPartida;
import edu.fiuba.algo3.vista.vistas.VistaLimitePreguntas;
import edu.fiuba.algo3.vista.vistas.VistaPedirNombreJugadores;
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

    private void crearAlgohoot(String limitePuntuacion) {

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

        Limite limite =  new LimitadorPorPuntos( preguntas);
        Limite limiteDecorator = new PuntosDefinidosDecorator(limite, preguntas,Integer.parseInt(limitePuntuacion));
        AlgoHoot algoHoot = new AlgoHoot(jugadores, limiteDecorator);

        this.algoHoot = algoHoot;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String seleccion = comboBoxLimitesPuntuacion.getValue();
        if (seleccion == null || seleccion.isEmpty()) {
            Alert limitePuntuacionSinSeleccionar = new Alert(Alert.AlertType.ERROR);
            limitePuntuacionSinSeleccionar.setHeaderText("No selecciono un limite de puntacion ");
            limitePuntuacionSinSeleccionar.setContentText("Debe seleccionar un limite de puntacion para poder empezar a jugar. ");
            limitePuntuacionSinSeleccionar.show();

        } else {
            crearAlgohoot(seleccion);
            pantallaPrincipal.setCentro(new VistaGeneralPartida(stage, pantallaPrincipal,algoHoot));

        }

    }
}
