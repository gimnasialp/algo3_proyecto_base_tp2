package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.Iniciales.ControladorLimitePreguntas;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEmpezarJuego;
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

import java.util.ArrayList;

public class VistaLimitePuntacion extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private ComboBox<String> comboBoxCantidadPuntos;
    private ArrayList<Jugador> jugadores;

    public VistaLimitePuntacion(Stage stage, PantallaPrincipal pantallaPrincipal, ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        configurarFondo();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);
        this.comboBoxCantidadPuntos = new ComboBox<>();
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


        Label labelCantidadPuntos = new Label("Seleccione la cantidad de puntos maximos: ");
        labelCantidadPuntos.setFont(Font.font(Estilos.FUENTE, 30));
        labelCantidadPuntos.setTextFill(Color.web(Estilos.AMARILLO));

        comboBoxCantidadPuntos.getItems().addAll("10", "15", "20", "30", "50", "75", "100");
        comboBoxCantidadPuntos.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");
        cajaPregunta.getChildren().add(comboBoxCantidadPuntos);

        vboxContenido.getChildren().addAll(labelCantidadPuntos, comboBoxCantidadPuntos);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        cajaPregunta.getChildren().add(contenedor);


        return cajaPregunta;
    }

    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonEmpezarJuego botonEmpezarJuego = new BotonEmpezarJuego(new ControladorLimitePreguntas(stage,pantallaPrincipal,comboBoxCantidadPuntos,jugadores));
        botonConfirmado.getChildren().add(botonEmpezarJuego);
        return botonConfirmado;
    }
}
