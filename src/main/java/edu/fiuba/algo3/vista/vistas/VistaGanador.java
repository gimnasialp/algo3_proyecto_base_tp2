package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorFinalizarJuego;
import edu.fiuba.algo3.controladores.ControladorReiniciarJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonReiniciarJuego;
import edu.fiuba.algo3.vista.botones.BotonTerminarJuego;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class VistaGanador extends StackPane {
    private Stage stage;

    public VistaGanador(Stage stagePrincipal, PantallaPrincipal contenedorPrincipal, Jugador jugador) {
        this.stage = stagePrincipal;
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,
                BackgroundRepeat.ROUND,
                BackgroundRepeat.SPACE,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, false));

        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        Image imagenPapelPicado = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/confitesGanador.gif");
        ImageView imageviewpapel = new ImageView(imagenPapelPicado);
        imageviewpapel.setFitHeight(720);
        imageviewpapel.setFitWidth(1280);
        imageviewpapel.setPreserveRatio(true);
        //imageviewpapel.
        super.getChildren().add(imageviewpapel);

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);
        grilla.setAlignment(Pos.CENTER);

        VBox cajaPrincipal = new VBox(50);
        cajaPrincipal.setAlignment(Pos.CENTER);
        AlgoHootMensaje textoAlgoHootInicio = new AlgoHootMensaje(Estilos.GRIS);
        cajaPrincipal.getChildren().add(textoAlgoHootInicio);

        VBox cajaGanador = new VBox();
        cajaGanador.setAlignment(Pos.TOP_CENTER);
        cajaGanador.setPadding(new Insets(90, 0, 0, 0));

        ArmarGanador(cajaGanador, jugador);

        VBox cajaInferior = new VBox(10);
        cajaInferior.setAlignment(Pos.TOP_CENTER);

        BotonReiniciarJuego botonReiniciarJuego = new BotonReiniciarJuego(new ControladorReiniciarJuego(stage, contenedorPrincipal));
        cajaInferior.getChildren().add(botonReiniciarJuego);

        BotonTerminarJuego botonTerminarJuego = new BotonTerminarJuego(new ControladorFinalizarJuego());
        cajaInferior.getChildren().add(botonTerminarJuego);

        grilla.add(cajaPrincipal, 0, 0);
        grilla.add(cajaGanador, 0, 1);
        grilla.add(cajaInferior, 0, 2);
        grilla.setAlignment(Pos.CENTER);  // Asegura que la grilla esté centrada
        super.getChildren().add(grilla);
    }

    private void ArmarGanador(VBox cajaGanador, Jugador jugadorGanador) {
        TextFlow flow = new TextFlow();

        Text textoElGanadorEs = new Text("El Ganador es ");
        textoElGanadorEs.setStyle("-fx-font-weight: regular");
        textoElGanadorEs.setFont(Font.font(Estilos.FUENTE, 60));

        Text textoCon = new Text(" con ");
        textoCon.setStyle("-fx-font-weight: regular");
        textoCon.setFont(Font.font(Estilos.FUENTE, 60));

        Text nombreGanador = new Text(jugadorGanador.getNombre());
        nombreGanador.setStyle("-fx-font-weight: bold");
        nombreGanador.setFont(Font.font(Estilos.FUENTE, 80));

        Text textoPuntosGanador = new Text("" + jugadorGanador.getPuntaje().obtenerPuntos());
        textoPuntosGanador.setStyle("-fx-font-weight: bold");
        textoPuntosGanador.setFont(Font.font(Estilos.FUENTE, 80));

        Text textoPuntos = new Text();
        textoPuntos.setStyle("-fx-font-weight: regular");
        textoPuntos.setFont(Font.font(Estilos.FUENTE, 60));

        if (Math.abs(jugadorGanador.obtenerPuntaje()) != 1) {
            textoPuntos.setText(" puntos.");
        } else {
            textoPuntos.setText(" punto.");
        }

        flow.getChildren().addAll(textoElGanadorEs, nombreGanador, textoCon, textoPuntosGanador, textoPuntos);
        flow.setTextAlignment(TextAlignment.CENTER);
        cajaGanador.getChildren().add(flow);
    }
}