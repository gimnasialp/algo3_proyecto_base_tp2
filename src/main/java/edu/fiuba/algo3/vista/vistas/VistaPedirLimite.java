package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorCantidadJugadores;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonInicio;
import edu.fiuba.algo3.vista.botones.BotonSiguiente;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class VistaPedirLimite extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private static final String FUENTE = "Arial";

    public VistaPedirLimite(Stage stage, PantallaPrincipal pantallaPrincipal) {
        configurarFondo();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);

        VBox nombreJuego = crearNombreJuego();
        VBox cajaPregunta = crearCajaPregunta();
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);
        grilla.add(nombreJuego, 0, 0);
        grilla.add(cajaPregunta, 0, 1);
        grilla.add(botonConfirmado, 0, 2);

        super.getChildren().add(grilla);
    }

    private void configurarFondo() {
        Image imagen = new Image("file:" + System.getProperty("user.dir") + IMAGEN_RUTA);
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);
    }

    private VBox crearNombreJuego() {
        VBox nombreJuego = new VBox(0);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootMensaje textoAlgoHootInicio = new AlgoHootMensaje(Estilos.GRIS);
        nombreJuego.getChildren().add(textoAlgoHootInicio);
        return nombreJuego;
    }

    private VBox crearCajaPregunta() {
        VBox cajaPregunta = new VBox(ESPACIADO_CENTRAL);
        cajaPregunta.setAlignment(Pos.CENTER);

        Label labelCantidadPreguntas = new Label("Ingrese limistes de preguntas :");
        labelCantidadPreguntas.setFont(Font.font(FUENTE, 30));
        labelCantidadPreguntas.setTextFill(Color.web(Estilos.AMARILLO));
        cajaPregunta.getChildren().add(labelCantidadPreguntas);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("25","50","75","100");
        comboBox.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");
        cajaPregunta.getChildren().add(comboBox);

        Label labelCantidadPuntos = new Label("Ingrese limistes de puntos :");
        labelCantidadPuntos.setFont(Font.font(FUENTE, 30));
        labelCantidadPuntos.setTextFill(Color.web(Estilos.AMARILLO));
        cajaPregunta.getChildren().add(labelCantidadPuntos);

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000");
        comboBox2.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");
        cajaPregunta.getChildren().add(comboBox2);

        return cajaPregunta;
    }

    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonSiguiente botonSiguiente = new BotonSiguiente(new ControladorCantidadJugadores(stage, pantallaPrincipal));
        botonConfirmado.getChildren().add(botonSiguiente);
        return botonConfirmado;
    }

}
