package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarVFClasico;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuestaOrderedChoice;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerOrderedChoice;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import edu.fiuba.algo3.vista.vistas.GrillaOpcionesPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaVFClasico extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Partida partida;
    private Pregunta pregunta;

    public VistaVFClasico(AlgoHoot algoHoot, Stage stagePrincipal, PantallaPrincipal pantallaPrincipal) {
        configurarFondo();
        this.partida = algoHoot.obtenerPartidaActiva();

        Pregunta preguntaVF = algoHoot.obtenerpreguntas().stream().filter(p -> p.mismoId(3)).findFirst().get();
        this.pregunta = preguntaVF;
        ArrayList<String> opciones = partida.obtenerPreguntaActual().obtenerOpciones();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);


        // VBox cajaPregunta = crearContenedorPregunta(partida.obtenerPreguntaActual());
        VBox cajaPregunta = crearContenedorPregunta(pregunta);
        VBox cajaInferior = armarRespuestas();

        grilla.add(cajaPregunta, 0, 0);
        grilla.add(cajaInferior, 0, 1);
        super.getChildren().add(grilla);

    }

    private VBox crearContenedorPregunta(Pregunta preguntaActual) {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(20)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        VBox vboxContenido = new VBox(20); // HBox para alinear el label y el textfield horizontalmente
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        Label tipoPreguntaActual = new Label("ENUNCIADO: " + preguntaActual.obtenerEnunciado());
        tipoPreguntaActual.setFont(Font.font(Estilos.FUENTE, 25));
        tipoPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));
        vboxContenido.getChildren().addAll(tipoPreguntaActual);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);


        return contenedorPregunta;
    }

    private VBox armarRespuestas() {
        VBox cajaOpciones = new VBox();
        Button botonVerdadero = new Button("Verdadero");
        botonVerdadero.setStyle("-fx-font-size: 30px;");

        Button botonFalso = new Button("Falso");
        botonFalso.setStyle("-fx-font-size: 30px;");

        botonVerdadero.setOnAction(e -> {

        });

        botonFalso.setOnAction(e -> {

        });

        cajaOpciones.getChildren().addAll(botonVerdadero, botonFalso);
        cajaOpciones.setAlignment(Pos.CENTER);

        StackPane contenedor = new StackPane(cajaOpciones);
        contenedor.setAlignment(Pos.CENTER);

        this.getChildren().add(contenedor);
        return cajaOpciones;
    }

    private VBox armarPregunta(VBox cajaPregunta) {

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(220, 380);
        grillaOpciones.setAlignment(Pos.CENTER);

        VBox cajaOpciones = new VBox(10);


        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        grillaOpciones.add(cajaOpciones, 1, 0);
        //cajaPregunta.getChildren().add(new MensajePregunta(partida.obtenerPreguntaActual().obtenerEnunciado()));
        cajaPregunta.getChildren().add(new MensajePregunta(pregunta.obtenerEnunciado()));
        return cajaPregunta;
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


}



