package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.Iniciales.ControladorGeneralPartida;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.CajaJugador;
import edu.fiuba.algo3.vista.GrillaGeneralPartida;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonEmpezarTurnos;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaGeneralPartida extends StackPane {
    private static final String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg";
    private static final double ANCHO_VENTANA = 1280;
    private static final double ALTO_VENTANA = 720;
    private static final double ESPACIADO_CENTRAL = 40;

    public VistaGeneralPartida(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot AlgoHoot) {
        configurarFondo();
        GrillaGeneralPartida grilla = new GrillaGeneralPartida(ANCHO_VENTANA, ALTO_VENTANA);
        HBox contenedorPregunta = crearContenedorPregunta();
        HBox contenedorJugadores = crearContenedorJugadores(3);
        VBox botonConfirmado = crearBotonConfirmado(stage, pantallaPrincipal);

        grilla.add(contenedorJugadores, 0, 1);
        grilla.add(botonConfirmado, 0, 2);
        grilla.setAlignment(Pos.CENTER);
        super.getChildren().add(grilla);
    }

    private HBox crearContenedorPregunta() {

        HBox contenedorPregunta = new HBox();

        return contenedorPregunta;
    }

    private HBox crearContenedorJugadores(int cantidadJugadores) {
        HBox contenedorJugadores = new HBox(ESPACIADO_CENTRAL);// Aca asigno el espacio entre cada contenedor
        contenedorJugadores.setAlignment(Pos.CENTER);
        ArrayList <String> nombresjugadores = new ArrayList();
        nombresjugadores.add("carlos");
        nombresjugadores.add("Nicolas");
        nombresjugadores.add("Alejandro");
        nombresjugadores.add("Nahuel");

        for (int i = 0; i < 4; i++) {
            HBox cajaJugador = crearCajaJugador(nombresjugadores.get(i));
            contenedorJugadores.getChildren().add(cajaJugador);
        }

        return contenedorJugadores;
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


    private HBox crearCajaJugador(String nombreJugador) {
        Jugador jugador = new Jugador(nombreJugador);
        CajaJugador cajaJugador = new CajaJugador(jugador, Estilos.AZUL);
        cajaJugador.setPrefSize(200, 300);

        return cajaJugador;
    }

    private VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal) {
        VBox botonConfirmado = new VBox(0);
        botonConfirmado.setAlignment(Pos.BOTTOM_CENTER);
        BotonEmpezarTurnos botonEmpezarRondaTurnos = new BotonEmpezarTurnos
                (new ControladorGeneralPartida(stage, pantallaPrincipal));
        botonConfirmado.getChildren().add(botonEmpezarRondaTurnos);
        return botonConfirmado;
    }


}
