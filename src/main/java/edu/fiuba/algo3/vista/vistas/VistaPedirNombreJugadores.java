package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorPedirNombreJugadores;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonSiguiente;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaPedirNombreJugadores extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private ArrayList<TextField> nombresIngresados;

    public VistaPedirNombreJugadores(Stage stage, PantallaPrincipal pantallaPrincipal,int cantidadJugadores) {
        configurarFondo();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);
        this.nombresIngresados = new ArrayList<>();

        VBox nombreJuego = crearNombreJuego();
        VBox cajaPregunta = crearCajaNombreJugadores(cantidadJugadores);

        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);

        grilla.add(nombreJuego, 0, 0);
        grilla.add(cajaPregunta, 0, 1);
        grilla.add(botonConfirmado, 2, 3);

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


    private VBox crearCajaNombreJugadores(int cantidadJugadores) {
        VBox cajaNombreJugadores = new VBox(ESPACIADO_CENTRAL);
        cajaNombreJugadores.setAlignment(Pos.CENTER);

        for (int i = 0; i < cantidadJugadores; i++) {
            // Crear un contenedor con fondo coloreado
            StackPane contenedor = new StackPane();
            contenedor.setPadding(new Insets(7)); // Ajusta el padding según sea necesario
            contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

            HBox hboxContenido = new HBox(7); // HBox para alinear el label y el textfield horizontalmente
            hboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
            hboxContenido.setPadding(new Insets(7)); // Ajustar el padding interno del HBox

            Label labelNombreJugador = new Label("Ingrese el nombre del jugador " + (i + 1) + ":");
            labelNombreJugador.setFont(Font.font(Estilos.FUENTE, 30)); // Ajusta el tamaño de la letra
            labelNombreJugador.setTextFill(Color.web(Estilos.AMARILLO));

            TextField campoNombreJugador = new TextField();
            campoNombreJugador.setMaxWidth(300);

            nombresIngresados.add(campoNombreJugador);

            // Añadir label y textField al HBox interno
            hboxContenido.getChildren().addAll(labelNombreJugador, campoNombreJugador);

            // Añadir HBox interno al contenedor con fondo
            contenedor.getChildren().add(hboxContenido);

            // Añadir el contenedor al VBox principal
            cajaNombreJugadores.getChildren().add(contenedor);
        }

        return cajaNombreJugadores;
    }

    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonSiguiente botonSiguiente = new BotonSiguiente(new ControladorPedirNombreJugadores(stage,pantallaPrincipal,nombresIngresados));
        botonConfirmado.getChildren().add(botonSiguiente);
        return botonConfirmado;
    }
}
