package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorCantidadJugadores;
import edu.fiuba.algo3.controladores.ControladorIniciarJuego;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonInicio;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaPedirCantidadJugadores extends StackPane {


    public VistaPedirCantidadJugadores(Stage stage, PantallaPrincipal pantallaPrincipal) {
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);

        VBox nombreJuego = new VBox(0);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootMensaje textoAlgoHootInicio = new AlgoHootMensaje(Estilos.GRIS);
        nombreJuego.getChildren().add(textoAlgoHootInicio);

        VBox cajaPregunta = new VBox(30);
        cajaPregunta.setAlignment(Pos.CENTER);

        Label labelCantidadJugadores = new Label("Ingrese la cantidad de jugadores (Max. 4jugadores)");
        labelCantidadJugadores.setFont(Font.font(Estilos.FUENTE,30));
        labelCantidadJugadores.setTextFill(Color.web(Estilos.AMARILLO));
        cajaPregunta.getChildren().add(labelCantidadJugadores);

        TextField campoCantidadJugadores = new TextField();
        campoCantidadJugadores.setMaxWidth(300);
        cajaPregunta.getChildren().add(campoCantidadJugadores);


        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);

        BotonInicio botonInicio = new BotonInicio(new ControladorCantidadJugadores(stage, pantallaPrincipal));
        botonConfirmado.getChildren().add(botonInicio);

        grilla.add(nombreJuego,0,0);
        grilla.add(cajaPregunta,0,1);
        grilla.add(botonConfirmado,0,2);

        super.getChildren().add(grilla);
    }
}
