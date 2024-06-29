package edu.fiuba.algo3.vista.mensajes;

import edu.fiuba.algo3.Estilos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MensajeSinMultiplicadores extends Label {

    public MensajeSinMultiplicadores(){
        super.setFont(Font.font(Estilos.FUENTE,20));
        super.setTextFill(Color.BLACK);
        super.setAlignment(Pos.CENTER);
        Insets paddingSinMultiplicador = new Insets(10,10,10,10);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color rojoTransparente = Color.web(Estilos.ROJO,Estilos.ALPHA_OPCIONES);
        super.setBackground(new Background(new BackgroundFill(rojoTransparente,bordeRedondeado,null)));
        super.setPadding(paddingSinMultiplicador);
        super.setText("Se quedo sin multiplicadores.");
    }

}
