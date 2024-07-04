package edu.fiuba.algo3.vista.mensajes;

import edu.fiuba.algo3.Estilos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AlgoHootMensaje extends Label {

    public AlgoHootMensaje(String color) {
        super("AlgoHoot!");
        super.setFont(Font.font(Estilos.FUENTE, 80));
        super.setTextFill(Color.web(color));
        super.setWrapText(true);
    }
}
