package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.mensajes.MensajePregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CajaPregunta extends HBox {

    private static final double ANCHO_CAJA = 200;
    private static final double ALTO_CAJA = 200;

    private static final double ESPACIADO_CAJA_PREGUNTA = 10;

    public CajaPregunta() {

        MensajePregunta enunciado = new MensajePregunta("Pregunta");
        super.getChildren().add(enunciado);
        super.setSpacing(ESPACIADO_CAJA_PREGUNTA);
        super.setAlignment(Pos.CENTER);
    }

}
