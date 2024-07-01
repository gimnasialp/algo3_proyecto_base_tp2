package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorCantidadJugadores;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonSiguiente;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaPedirCantidadJugadores extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private ComboBox<String> comboBoxCantidadJugadores;

    public VistaPedirCantidadJugadores(Stage stage, PantallaPrincipal pantallaPrincipal) {
        configurarFondo();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);

        comboBoxCantidadJugadores = new ComboBox<>();

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
        BackgroundImage fondoImagen = new BackgroundImage(imagen,
                BackgroundRepeat.ROUND,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, false));
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);
    }

    private VBox crearNombreJuego() {
        VBox nombreJuego = new VBox(1);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootMensaje textoAlgoHootInicio = new AlgoHootMensaje(Estilos.GRIS);
        nombreJuego.getChildren().add(textoAlgoHootInicio);
        return nombreJuego;
    }

    private VBox crearCajaPregunta() {
        VBox cajaPregunta = new VBox(ESPACIADO_CENTRAL);
        cajaPregunta.setAlignment(Pos.CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(7)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        HBox hboxContenido = new HBox(7); // HBox para alinear el label y el textfield horizontalmente
        hboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        hboxContenido.setPadding(new Insets(10));

        Label labelCantidadJugadores = new Label("Seleccione la cantidad de jugadores totales:");
        labelCantidadJugadores.setFont(Font.font(Estilos.FUENTE, 30));
        labelCantidadJugadores.setTextFill(Color.web(Estilos.AMARILLO));


        comboBoxCantidadJugadores.getItems().addAll("2", "3", "4");
        comboBoxCantidadJugadores.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");

        hboxContenido.getChildren().addAll(labelCantidadJugadores, comboBoxCantidadJugadores);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(hboxContenido);

        // Añadir el contenedor al VBox principal
        cajaPregunta.getChildren().add(contenedor);

        return cajaPregunta;
    }
    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonSiguiente botonSiguiente = new BotonSiguiente(new ControladorCantidadJugadores(stage, pantallaPrincipal, comboBoxCantidadJugadores));
        botonConfirmado.getChildren().add(botonSiguiente);
        return botonConfirmado;
    }

}
