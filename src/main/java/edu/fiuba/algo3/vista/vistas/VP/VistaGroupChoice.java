package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGroupChoice;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuestaGroupChoice;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerGroupChoice;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import edu.fiuba.algo3.vista.vistas.GrillaOpcionesPregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VistaGroupChoice extends StackPane {

    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Partida partida;
    private PreguntaGroupChoice preguntaGroupChoice;
    private Map<Integer, Spinner<String>> spinners = new HashMap<>();

    public VistaGroupChoice(AlgoHoot algoHoot, Stage stage, PantallaPrincipal pantallaPrincipal) {

        configurarFondo();
        this.partida = algoHoot.obtenerPartidaActiva();
        this.preguntaGroupChoice = (PreguntaGroupChoice) partida.obtenerPreguntaActual();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);

        VBox cajaPregunta = armarPregunta();
        cajaPregunta.setAlignment(Pos.TOP_CENTER);
        cajaPregunta.setPrefWidth(600);

        VBox cajaInferior = new VBox(20);

        cajaInferior.getChildren().add(crearCajaInferior(stage, pantallaPrincipal, algoHoot));
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(cajaPregunta, 0, 0);
        grilla.add(cajaInferior, 0, 1);

        super.getChildren().add(grilla);
    }

    private VBox armarPregunta() {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(30)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 10px;");

        VBox vboxContenido = new VBox(40);
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        MensajePregunta mensajePregunta = new MensajePregunta(preguntaGroupChoice.obtenerEnunciado());
        Label tipoPreguntaActual = new Label("ENUNCIADO: " + mensajePregunta.getText());
        Tooltip tooltip = new Tooltip(mensajePregunta.getText());
        Tooltip.install(this, tooltip);


        tipoPreguntaActual.setFont(Font.font(Estilos.FUENTE, 25));
        tipoPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));
        vboxContenido.getChildren().addAll(tipoPreguntaActual);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);

        return contenedorPregunta;
    }

    private VBox crearCajaInferior(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        VBox cajaOpciones = new VBox(10);
        cajaOpciones.setAlignment(Pos.CENTER);
        ////Manejo ddatos de la pregunta//
        ControladorEnviarGroupChoice controladorRespondioUsuario = new ControladorEnviarGroupChoice(
                preguntaGroupChoice.consultarGruposPregunta(),
                stage,
                pantallaPrincipal,
                algoHoot);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(30)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 10px;");

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(180, 420);
        grillaOpciones.setAlignment(Pos.CENTER);

        for (String opcion : preguntaGroupChoice.obtenerOpciones()) {
            SpinnerGroupChoice boton = new SpinnerGroupChoice(preguntaGroupChoice.consultarGruposPregunta(), opcion, controladorRespondioUsuario);
            boton.setAlignment(Pos.CENTER_LEFT);
            cajaOpciones.getChildren().add(boton);
        }
        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        contenedor.getChildren().add(cajaOpciones);
        grillaOpciones.add(cajaOpciones, 0, 0);
        BotonEnviarRespuestaGroupChoice botonEnviar = new BotonEnviarRespuestaGroupChoice(controladorRespondioUsuario, cajaOpciones);
        botonEnviar.setAlignment(Pos.CENTER_LEFT);
        cajaOpciones.getChildren().add(botonEnviar);
        return cajaOpciones;
    }

    private void crearBoton() {
        Button btnRecogerRespuestas = new Button("Recoger Respuestas");
        btnRecogerRespuestas.setOnAction(e -> {
            ArrayList<Integer> grupoA = new ArrayList<>();
            ArrayList<Integer> grupoB = new ArrayList<>();
            for (Map.Entry<Integer, Spinner<String>> entry : spinners.entrySet()) {
                int opcion = entry.getKey();
                String grupo = entry.getValue().getValue();
                if ("Grupo A".equals(grupo)) {
                    grupoA.add(opcion);
                } else {
                    grupoB.add(opcion);
                }
            }
            RespuestaGroupChoice respuesta = new RespuestaGroupChoice(grupoA, grupoB);
        });
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