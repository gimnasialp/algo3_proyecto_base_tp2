package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuestaGroupChoice;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerGroupChoice;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import edu.fiuba.algo3.vista.vistas.GrillaOpcionesPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaGroupChoice extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Partida partida;

    public VistaGroupChoice(AlgoHoot algoHoot, Stage stage, PantallaPrincipal pantallaPrincipal) {

        configurarFondo();
        this.partida = algoHoot.obtenerPartidaActiva();


        GrillaBasePreguntas grilla = new GrillaBasePreguntas(1280, 720);
/*
        VBox cajaPregunta = armarPregunta(partida.obtenerPreguntaActual(),)
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        cajaPregunta.setPrefWidth(600);*/

        VBox cajaInferior = new VBox(20);

        //ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(nombresGrupos, stage, pantallaPrincipal);
        //VBox cajaOpciones = armarPregunta(nombresGrupos, cajaPregunta, pregunta, controladorRespondioUsuario);

        //BotonEnviarRespuestaGroupChoice botonEnviar = new BotonEnviarRespuestaGroupChoice(controladorRespondioUsuario, cajaOpciones);

        //cajaInferior.getChildren().add(crearCajaInferior());
        cajaInferior.setAlignment(Pos.CENTER);

        //grilla.add(cajaPregunta, 0, 1);
        grilla.add(cajaInferior, 0, 2);

        super.getChildren().add(grilla);
    }

    private VBox armarPregunta(PreguntaGroupChoice preguntaGroupChoice, ControladorEnviarGroupChoice controlador) {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(20)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        VBox vboxContenido = new VBox(20);
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        MensajePregunta mensajePregunta = new MensajePregunta(preguntaGroupChoice.obtenerEnunciado());
        Label tipoPreguntaActual = new Label("ENUNCIADO: " + mensajePregunta.getText());
        tipoPreguntaActual.setFont(Font.font(Estilos.FUENTE, 25));
        tipoPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));
        vboxContenido.getChildren().addAll(tipoPreguntaActual);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);


        ArrayList<String> opciones = preguntaGroupChoice.obtenerOpciones();

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(180, 420);
        grillaOpciones.setAlignment(Pos.CENTER);

        VBox cajaOpciones = new VBox(10);
        cajaOpciones.setAlignment(Pos.CENTER);

        for (String opcion : opciones) {
            //SpinnerGroupChoice boton = new SpinnerGroupChoice(nombresGrupos, opcion, controlador);
            //boton.setAlignment(Pos.CENTER_LEFT);
            //cajaOpciones.getChildren().add(boton);
        }
        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        grillaOpciones.add(cajaOpciones, 1, 0);
        //cajaPregunta.getChildren().add(grillaOpciones);
        return contenedorPregunta;
    }
    private VBox crearCajaInferior(PreguntaGroupChoice preguntaGroupChoice){
        VBox cajaInferior = new VBox(10);

        //ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(preguntaGroupChoice.consultarGruposPregunta(), stage, pantallaPrincipal);
        //VBox cajaOpciones = armarPregunta(nombresGrupos, cajaPregunta, pregunta, controladorRespondioUsuario);

        //BotonEnviarRespuestaGroupChoice botonEnviar = new BotonEnviarRespuestaGroupChoice(controladorRespondioUsuario, cajaOpciones);

        return cajaInferior;
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
