package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaVFPenalidad extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Stage stage;
    private Partida partida;

    public VistaVFPenalidad(Partida partida, Stage stage, PantallaPrincipal pantallaPrincipal) {


        configurarFondo();
        this.partida = partida;

        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
    /*   VBox cajaPregunta = crearContenedorPregunta(partidaActual.obtenerPreguntaActual());
       VBox botonModificador = crearBotonModificador(stage, pantallaPrincipal);
       VBox CajaBotonPregunta = crearBotonPregunta(stage, pantallaPrincipal);
        grilla.add(cajaPregunta, 0, 0);
        grilla.add(botonModificador, 0, 1);
        grilla.add(CajaBotonPregunta, 0, 2);
     */   grilla.setAlignment(Pos.CENTER);
        super.getChildren().add(grilla);


    }
        /*super();
        this.stage = stage;

        configurarFondo();

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        PreguntaVerdaderoFalsoClasico pregunta = (PreguntaVerdaderoFalsoClasico) partida.obtenerPreguntaActual();
        Label preguntaLabel = new Label(pregunta.obtenerEnunciado());
        preguntaLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");

        Button botonVerdadero = new Button("Verdadero");
        botonVerdadero.setStyle("-fx-font-size: 18px;");

        Button botonFalso = new Button("Falso");
        botonFalso.setStyle("-fx-font-size: 18px;");

        botonVerdadero.setOnAction(e -> {
            // Lógica para respuesta verdadera
        });

        botonFalso.setOnAction(e -> {
            // Lógica para respuesta falsa
        });

        vbox.getChildren().addAll(preguntaLabel, botonVerdadero, botonFalso);

        Rectangle fondoRectangulo = new Rectangle(350, 200);
        fondoRectangulo.setFill(Paint.valueOf(Estilos.VIOLETA));
        fondoRectangulo.setArcWidth(20);
        fondoRectangulo.setArcHeight(20);

        StackPane contenedor = new StackPane(fondoRectangulo, vbox);
        contenedor.setAlignment(Pos.CENTER);

        this.getChildren().add(contenedor);
    }*/

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
}