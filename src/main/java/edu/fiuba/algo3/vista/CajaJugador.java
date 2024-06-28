package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.vista.vistas.cajaModificadores;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class CajaJugador extends HBox {

    public CajaJugador(String nombre, int puntos) {
        Label labelNombreJugador = new Label(nombre);
        labelNombreJugador.setFont(Font.font(Estilos.FUENTE,40));
        labelNombreJugador.setTextFill(Color.BLACK);
        labelNombreJugador.setWrapText(true);

        Label puntosJugador = new Label(String.valueOf(puntos));

        puntosJugador.setFont(Font.font(Estilos.FUENTE,25));
        puntosJugador.setTextFill(Color.BLACK);

        super.setMinSize(140,50);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        super.setBackground(new Background(new BackgroundFill(Color.web(Estilos.AZUL), Estilos.BORDE_CURVO,null)));

        String exclusividad = "E";
        String anulador = "A" ;
        String multiplicadorX2 = "x2";
        String multiplicadorX3 = "x3";

        cajaModificadores cajaBonusJugador = new cajaModificadores(exclusividad,anulador,multiplicadorX3,multiplicadorX2);

        super.getChildren().add(labelNombreJugador);
        super.getChildren().add(puntosJugador);
        super.getChildren().add(cajaBonusJugador);
        super.setAlignment(Pos.CENTER);

    }
}
