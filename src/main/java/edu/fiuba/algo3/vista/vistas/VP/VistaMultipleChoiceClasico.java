package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuestaMultipleChoice;
import edu.fiuba.algo3.vista.botones.BotonOpcionMultipleChoice;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import edu.fiuba.algo3.vista.vistas.GrillaOpcionesPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaMultipleChoiceClasico extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Partida partida;

    public VistaMultipleChoiceClasico(AlgoHoot algoHoot, Stage stagePrincipal, PantallaPrincipal pantallaPrincipal) {
        configurarFondo();
        this.partida = algoHoot.obtenerPartidaActiva();

        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);

        VBox cajaPregunta = crearContenedorPregunta(partida.obtenerPreguntaActual());
        cajaPregunta.setPrefWidth(600);
        cajaPregunta.setAlignment(Pos.TOP_CENTER);

        ControladorEnviarMultipleChoice controladorRespondioUsuario = new ControladorEnviarMultipleChoice(stagePrincipal, pantallaPrincipal, algoHoot);


        VBox cajaOpciones = armarOpciones(cajaPregunta, partida.obtenerPreguntaActual(), controladorRespondioUsuario);


        VBox cajaInferior = new VBox();
        BotonEnviarRespuestaMultipleChoice botonEnviar = new BotonEnviarRespuestaMultipleChoice(controladorRespondioUsuario);
        cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(cajaPregunta, 0, 1);
        grilla.add(cajaInferior, 0, 2);
        super.getChildren().add(grilla);

    }


    private VBox crearContenedorPregunta(Pregunta preguntaActual) {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(20)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        VBox vboxContenido = new VBox(20);
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        MensajePregunta mensajePregunta = new MensajePregunta(preguntaActual.obtenerEnunciado());
        Tooltip tooltip = new Tooltip(mensajePregunta.getText());
        Tooltip.install(this, tooltip);

        vboxContenido.getChildren().addAll(mensajePregunta);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);


        return contenedorPregunta;
    }


    private VBox armarOpciones(VBox cajaPregunta, Pregunta pregunta, ControladorEnviarMultipleChoice controlador) {

        ArrayList<String> opciones = pregunta.obtenerOpciones();

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(250, 350);
        grillaOpciones.setAlignment(Pos.CENTER);
        VBox cajaOpciones = new VBox(10);


        for (int i = 0; i < opciones.size(); i++) {
            String opcion = opciones.get(i);
            BotonOpcionMultipleChoice boton = new BotonOpcionMultipleChoice(opcion, i, controlador);
            cajaOpciones.getChildren().add(boton);
        }

        grillaOpciones.add(cajaOpciones, 0, 0);
        cajaPregunta.getChildren().add(grillaOpciones);
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
