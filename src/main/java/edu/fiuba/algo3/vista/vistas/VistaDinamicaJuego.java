package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.mensajes.AlgoHootMensaje;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public abstract class VistaDinamicaJuego extends StackPane {
    protected String IMAGEN_RUTA = "/src/main/java/edu/fiuba/algo3/resources/imagenes/";
    protected static final double ANCHO_VENTANA = 1280;
    protected static final double ALTO_VENTANA = 720;
    protected static final double ESPACIADO_CENTRAL = 40;

    public VistaDinamicaJuego(String nombreImagen, Stage stage, PantallaPrincipal pantallaPrincipal) {
        this.IMAGEN_RUTA += nombreImagen;
        configurarFondo();
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

    protected VBox crearNombreJuego() {
        VBox nombreJuego = new VBox(1);
        nombreJuego.setAlignment(Pos.TOP_CENTER);
        AlgoHootMensaje textoAlgoHootInicio = new AlgoHootMensaje(Estilos.GRIS);
        nombreJuego.getChildren().add(textoAlgoHootInicio);
        return nombreJuego;
    }

    protected abstract VBox crearBotonConfirmado(Stage stage, PantallaPrincipal pantallaPrincipal);
}