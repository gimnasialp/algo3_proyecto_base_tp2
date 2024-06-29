package edu.fiuba.algo3.vista.mensajes;

import edu.fiuba.algo3.Estilos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MensajePregunta extends Label {

    public MensajePregunta(String enunciado){
        super(enunciado);
        super.setFont(Font.font(Estilos.FUENTE,35));
        super.setTextFill(Color.BLACK);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setWrapText(true);
    }

}
