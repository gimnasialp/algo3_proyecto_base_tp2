package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonAccederPregunta;
import edu.fiuba.algo3.vista.botones.BotonMultiplicador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class VistaTurnoJugadorActual extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/Fondo2.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private AlgoHoot algoHoot;
    private Partida partidaActual;

    public VistaTurnoJugadorActual(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        configurarFondo();
        this.algoHoot = algoHoot;
        this.partidaActual = algoHoot.obtenerPartidaActiva();
        System.out.println(partidaActual.obtenerPreguntaActual().obtenerEnunciado());
        System.out.println(partidaActual.obtenerJugadorActivo().getNombre());
        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
        VBox cajaPregunta = crearContenedorPregunta(partidaActual.obtenerPreguntaActual());
        VBox botonModificador = crearBotonModificador(stage, pantallaPrincipal);
        VBox CajaBotonPregunta = crearBotonPregunta(stage, pantallaPrincipal);
        grilla.add(cajaPregunta, 0, 0);
        grilla.add(botonModificador, 0, 1);
        grilla.add(CajaBotonPregunta, 0, 2);
        grilla.setAlignment(Pos.CENTER);
        super.getChildren().add(grilla);

    }

    private VBox crearContenedorPregunta(Pregunta preguntaActual) {

        VBox contenedorPregunta = new VBox(ESPACIADO_CENTRAL);
        contenedorPregunta.setAlignment(Pos.TOP_CENTER);

        StackPane contenedor = new StackPane();
        contenedor.setPadding(new Insets(7)); // Ajusta el padding según sea necesario
        contenedor.setStyle("-fx-background-color: #9370DB; -fx-background-radius: 5px;");

        VBox vboxContenido = new VBox(7); // HBox para alinear el label y el textfield horizontalmente
        vboxContenido.setAlignment(Pos.CENTER); // Alinear al centro
        vboxContenido.setPadding(new Insets(10));

        Label tipoPreguntaActual = new Label("TIPO DE PREGUNTA: " + preguntaActual.ObtenerTipoPregunta());
        tipoPreguntaActual.setFont(Font.font(Estilos.FUENTE, 30));
        tipoPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));

        Label temaPreguntaActual = new Label("TEMA: " + preguntaActual.obtenerTema());
        temaPreguntaActual.setFont(Font.font(Estilos.FUENTE, 30));
        temaPreguntaActual.setTextFill(Color.web(Estilos.AMARILLO));


        vboxContenido.getChildren().addAll(tipoPreguntaActual, temaPreguntaActual);

        // Añadir HBox interno al contenedor con fondo
        contenedor.getChildren().add(vboxContenido);

        // Añadir el contenedor al VBox principal
        contenedorPregunta.getChildren().add(contenedor);


        return contenedorPregunta;
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

    private VBox crearBotonPregunta(Stage stage, PantallaPrincipal pantallaPrincipal){
        VBox cajaBotonAccederPregunta = new VBox(ESPACIADO_CENTRAL);
        cajaBotonAccederPregunta.setAlignment(Pos.CENTER);
        BotonAccederPregunta botonAccederPregunta = new BotonAccederPregunta(stage,pantallaPrincipal,algoHoot);
        cajaBotonAccederPregunta.getChildren().add(botonAccederPregunta);
        return cajaBotonAccederPregunta;
    }

    private VBox crearBotonModificador(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonMultiplicador botonMultiplicador = new BotonMultiplicador(new MultiplicarPorDos());
        cajaBotonModificador.getChildren().add(botonMultiplicador);
        return cajaBotonModificador;
    }

}
