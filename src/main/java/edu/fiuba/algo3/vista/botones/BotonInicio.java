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

public class BotonInicio extends Button {

    public BotonInicio(EventHandler<ActionEvent> controlador){
        super.setText("Iniciar juego");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setTextFill(Color.web(Estilos.BLANCO));
        super.setBorder(new Border(new BorderStroke(Color.web(Estilos.GRIS), BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondito = new Background(new BackgroundFill(Color.web(Estilos.VIOLETA, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(1)));
        super.setBackground(unFondito);

        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this,Estilos.AMARILLO));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.VIOLETA));
    }
}
