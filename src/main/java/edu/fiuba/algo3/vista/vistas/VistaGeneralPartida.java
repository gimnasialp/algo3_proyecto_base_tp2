package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.Iniciales.ControladorGeneralPartida;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.CajaJugador;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEmpezarTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class VistaGeneralPartida extends VistaDinamicaJuego {
    private AlgoHoot algoHoot;
    private Partida partidaActual;

    public VistaGeneralPartida(String nombreImagen, Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super(nombreImagen, stage, pantallaPrincipal);
        this.algoHoot = algoHoot;
        algoHoot.proximaPartida();
        this.partidaActual = algoHoot.obtenerPartidaActiva();

        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
        VBox cajaPregunta = crearContenedorPregunta(algoHoot.obtenerPartidaActiva().obtenerPreguntaActual());
        HBox contenedorJugadores = crearContenedorJugadores(algoHoot.obtenerPartidaActiva().getJugadores());
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);

        grilla.add(cajaPregunta, 0, 0);
        grilla.add(contenedorJugadores, 0, 1);
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

    private HBox crearContenedorJugadores(List<Jugador> jugadores) {
        HBox contenedorJugadores = new HBox(ESPACIADO_CENTRAL);// Aca asigno el espacio entre cada contenedor
        contenedorJugadores.setAlignment(Pos.CENTER);
        for (int i = 0; i < jugadores.size(); i++) {
            HBox cajaJugador = crearCajaJugador(jugadores.get(i));
            contenedorJugadores.getChildren().add(cajaJugador);
        }

        return contenedorJugadores;
    }

    private HBox crearCajaJugador(Jugador jugador) {
        CajaJugador cajaJugador = new CajaJugador(jugador, Estilos.AZUL);
        cajaJugador.setPrefSize(200, 300);
        return cajaJugador;
    }

    @Override
    protected VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonEmpezarTurnos botonEmpezarRondaTurnos = new BotonEmpezarTurnos
                (new ControladorGeneralPartida(stage, pantallaPrincipal,algoHoot));
        botonConfirmado.getChildren().add(botonEmpezarRondaTurnos);
        return botonConfirmado;
    }


}
