package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.Iniciales.ControladorLimitePreguntas;
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

public class VistaLimitePreguntas extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private ComboBox<String> comboBoxCantidadPreguntas;

    public VistaLimitePreguntas(Stage stage, PantallaPrincipal pantallaPrincipal) {
        configurarFondo();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);
        comboBoxCantidadPreguntas  = new ComboBox<>();

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

        VBox vboxContenido = new VBox(7); // HBox para alinear el label y el textfield horizontalmente
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        Label labelCantidadPreguntas = new Label("Seleccione la cantidad de preguntas maximas:");
        labelCantidadPreguntas.setFont(Font.font(Estilos.FUENTE, 30));
        labelCantidadPreguntas.setTextFill(Color.web(Estilos.AMARILLO));

        comboBoxCantidadPreguntas.getItems().addAll("25","30","50","100");
        comboBoxCantidadPreguntas.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");

        vboxContenido.getChildren().addAll(labelCantidadPreguntas, comboBoxCantidadPreguntas);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        cajaPregunta.getChildren().add(contenedor);


        return cajaPregunta;
    }

    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonSiguiente botonSiguiente = new BotonSiguiente(new ControladorLimitePreguntas(stage,pantallaPrincipal,comboBoxCantidadPreguntas));
        botonConfirmado.getChildren().add(botonSiguiente);
        return botonConfirmado;
    }
}
