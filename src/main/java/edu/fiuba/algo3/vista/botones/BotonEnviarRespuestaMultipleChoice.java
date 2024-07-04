package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonEnviarRespuestaMultipleChoice extends Button {

    public BotonEnviarRespuestaMultipleChoice(EventHandler<ActionEvent> controlador) {
        super.setText("Enviar respuesta");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.WHITE);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.VERDE, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(0)));
        super.setBackground(unFondo);
        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this, Estilos.VERDE));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.VERDE));
    }
}

