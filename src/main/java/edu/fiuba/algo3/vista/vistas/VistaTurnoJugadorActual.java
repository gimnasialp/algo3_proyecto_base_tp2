package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.MultiplicarPorDos;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
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
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;
    private AlgoHoot algoHoot;
    private Partida partidaActual;

    public VistaTurnoJugadorActual(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        configurarFondo();
        this.algoHoot = algoHoot;
        this.partidaActual = algoHoot.obtenerPartidaActiva();

        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
        VBox cajaPregunta = crearContenedorPregunta(algoHoot.obtenerPartidaActiva().obtenerPreguntaActual());
       // HBox contenedorJugadores = crearContenedorJugadores(algoHoot.obtenerPartidaActiva().getJugadores());
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);

        grilla.add(cajaPregunta, 0, 0);
        grilla.add(botonConfirmado, 0, 2);
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
/*

    private HBox crearCajaJugador(Jugador jugador) {
        CajaJugador cajaJugador = new CajaJugador(jugador, Estilos.AZUL);
        cajaJugador.setPrefSize(200, 300);
        return cajaJugador;
    }
*/
    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonMultiplicador botonMultiplicador = new BotonMultiplicador(new MultiplicarPorDos());
        botonConfirmado.getChildren().add(botonMultiplicador);
        return botonConfirmado;
    }

}
