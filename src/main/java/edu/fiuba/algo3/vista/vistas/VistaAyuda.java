package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.vista.mensajes.MensajeAyuda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaAyuda extends StackPane {

    public VistaAyuda() {
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/imagenVistaAyuda.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setPadding(new Insets(30));
        cajaPrincipal.setAlignment(Pos.TOP_CENTER);

        Label titulo = new Label("Ayuda sobre el juego");
        titulo.setFont(Font.font(Estilos.FUENTE,25));
        titulo.setStyle("-fx-font-weight: bold");
        titulo.setUnderline(true);
        titulo.setTextFill(Color.WHITE);
        titulo.setWrapText(true);

        cajaPrincipal.getChildren().add(titulo);
        cajaPrincipal.getChildren().add(new MensajeAyuda());

        super.getChildren().add(cajaPrincipal);
    }
}
