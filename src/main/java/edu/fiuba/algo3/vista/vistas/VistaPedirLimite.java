package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.Iniciales.ControladorPedirLimite;
import edu.fiuba.algo3.modelo.Jugador;
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

import java.util.ArrayList;


public class VistaPedirLimite extends VistaDinamicaJuego {

    private ComboBox<String> comboBoxTiposDeLimites;
    private ArrayList<Jugador> jugadores;

    public VistaPedirLimite(String nombreImagen, Stage stage, PantallaPrincipal pantallaPrincipal, ArrayList<Jugador> jugadores) {
        super(nombreImagen, stage, pantallaPrincipal);
        this.jugadores = jugadores;
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);
        this.comboBoxTiposDeLimites = new ComboBox<>();
        VBox nombreJuego = crearNombreJuego();
        VBox cajaPregunta = crearCajaPregunta();
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);
        grilla.add(nombreJuego, 0, 0);
        grilla.add(cajaPregunta, 0, 1);
        grilla.add(botonConfirmado, 0, 2);

        super.getChildren().add(grilla);
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

        Label labelCantidadPreguntas = new Label("Seleccione cómo desea terminar la partida:");
        labelCantidadPreguntas.setFont(Font.font(Estilos.FUENTE, 30));
        labelCantidadPreguntas.setTextFill(Color.web(Estilos.AMARILLO));

        comboBoxTiposDeLimites.getItems().addAll("Puntos","Cantidad de Preguntas");
        comboBoxTiposDeLimites.setStyle("-fx-font-size: 20px; -fx-pref-width: 200px;");


        vboxContenido.getChildren().addAll(labelCantidadPreguntas, comboBoxTiposDeLimites);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        cajaPregunta.getChildren().add(contenedor);


        return cajaPregunta;
    }

    @Override
    protected VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonSiguiente botonSiguiente = new BotonSiguiente(new ControladorPedirLimite(stage,pantallaPrincipal,comboBoxTiposDeLimites,jugadores));
        botonConfirmado.getChildren().add(botonSiguiente);
        return botonConfirmado;
    }

}
