package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonSinAnulador extends Button {

    public BotonSinAnulador() {
        super.setText("Sin Anulador");
        super.setFont(Font.font(Estilos.FUENTE, 15));
        super.setPadding(new Insets(5));
        super.setTextFill(Color.BLACK);
        super.setAlignment(Pos.CENTER);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.ROJO, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondo);
    }
}
