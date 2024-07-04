package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorAccederPregunta;
import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonAccederPregunta extends Button {

    public BotonAccederPregunta(Stage stage, PantallaPrincipal pantallaPrincipal, AlgoHoot algoHoot) {
        super.setText("Ir a la pregunta");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.BLACK);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.VERDE, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(0)));
        super.setBackground(unFondo);
        super.setAlignment(Pos.CENTER);
        super.setOnAction(new ControladorAccederPregunta(stage, pantallaPrincipal, algoHoot));
        super.setOnMouseEntered(new ControladorActivarBoton(this, Estilos.AMARILLO));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.VIOLETA));
    }
}
