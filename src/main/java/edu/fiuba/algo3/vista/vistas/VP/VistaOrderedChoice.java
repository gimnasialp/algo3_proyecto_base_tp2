package edu.fiuba.algo3.vista.vistas.VP;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.controladores.ControladorPedirNombreJugadores;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.GrillaBasePreguntas;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuestaOrderedChoice;
import edu.fiuba.algo3.vista.botones.BotonSiguiente;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerOrderedChoice;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import edu.fiuba.algo3.vista.vistas.GrillaOpcionesPregunta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class VistaOrderedChoice extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private Stage stage;


    public VistaOrderedChoice(Partida partidaActual, Stage stagePrincipal, PantallaPrincipal pantallaPrincipal) {
        this.stage = stagePrincipal;
        configurarFondo();
        ControladorEnviarOrderedChoice controladorRespondioUsuario = new ControladorEnviarOrderedChoice(stage, pantallaPrincipal, partidaActual);
        ArrayList<String> opcionesCorrectas = partidaActual.obtenerPreguntaActual().obtenerOpciones();
        GrillaBasePreguntas grilla = new GrillaBasePreguntas(ANCHO_VENTANA, ALTO_VENTANA);
        //GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);

        VBox cajaPregunta = new VBox(30);
        cajaPregunta.setPrefWidth(600);
        cajaPregunta.setAlignment(Pos.CENTER);

        VBox cajaOpciones = armarPregunta(cajaPregunta, controladorRespondioUsuario, opcionesCorrectas, partidaActual.obtenerPreguntaActual().obtenerEnunciado());


        VBox cajaInferior = new VBox();
        //BotonEnviarRespuestaOrderedChoice botonEnviar = new BotonEnviarRespuestaOrderedChoice(controladorRespondioUsuario, cajaOpciones, opcionesCorrectas);
       // cajaInferior.getChildren().add(botonEnviar);
        cajaInferior.setAlignment(Pos.CENTER);

        grilla.add(cajaPregunta, 0, 1);
        grilla.add(cajaInferior, 0, 2);
        super.getChildren().add(grilla);

    }

    private VBox armarPregunta(VBox cajaPregunta, ControladorEnviarOrderedChoice controlador, ArrayList<String> opciones, String textoPregunta) {

        GrillaOpcionesPregunta grillaOpciones = new GrillaOpcionesPregunta(220, 380);
        grillaOpciones.setAlignment(Pos.CENTER);

        VBox cajaOpciones = new VBox(5);

        for (String opcion : opciones) {
            SpinnerOrderedChoice opcionOrdenable = new SpinnerOrderedChoice(opcion, opciones.size(), controlador);
            opcionOrdenable.setAlignment(Pos.CENTER_LEFT);
            cajaOpciones.getChildren().add(opcionOrdenable);
        }

        cajaOpciones.setAlignment(Pos.TOP_LEFT);
        grillaOpciones.add(cajaOpciones, 1, 0);
        cajaPregunta.getChildren().add(new MensajePregunta(textoPregunta));
        cajaPregunta.getChildren().add(grillaOpciones);
        return cajaOpciones;
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
