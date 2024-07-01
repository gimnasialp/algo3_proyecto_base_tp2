package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CajaJugador extends HBox {

    private static final double ANCHO_CAJA = 200;
    private static final double ALTO_CAJA = 200;

    public CajaJugador(Jugador jugador, String color) {

        Label labelNombreJugador = new Label(jugador.getNombre());
        labelNombreJugador.setFont(Font.font(Estilos.FUENTE, 30));
        labelNombreJugador.setTextFill(Color.BLACK);
        labelNombreJugador.setWrapText(true);

        Label puntosJugador = new Label(String.valueOf(jugador.obtenerPuntaje()));
        puntosJugador.setFont(Font.font(Estilos.FUENTE, 25));
        puntosJugador.setTextFill(Color.BLACK);

        CajaModificadoresJugador cajaBonusJugador = new CajaModificadoresJugador(jugador);

        VBox vBox = new VBox(10); // Espaciado entre los elementos
        vBox.setAlignment(Pos.CENTER); // Centrar verticalmente los elementos
        vBox.getChildren().addAll(labelNombreJugador, puntosJugador/*, cajaBonusJugador*/);

        this.setMinSize(ANCHO_CAJA, ALTO_CAJA);
        this.setPrefSize(ANCHO_CAJA, ALTO_CAJA);
        this.setMaxSize(ANCHO_CAJA, ALTO_CAJA);

        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        this.setBackground(new Background(new BackgroundFill(Color.web(Estilos.AZUL), Estilos.BORDE_CURVO, null)));

        this.getChildren().add(vBox);
        this.setAlignment(Pos.CENTER); // Centrar horizontalmente los elementos en el HBox
    }
}

