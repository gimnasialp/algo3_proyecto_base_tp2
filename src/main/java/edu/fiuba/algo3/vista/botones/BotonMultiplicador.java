package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonMultiplicador extends Button {

    public BotonMultiplicador(String nombreModificador) {
        super.setText(nombreModificador);
        //super.setText("Usar Multiplicador x"+ multiplicador.consultarValor());
        super.setFont(Font.font(Estilos.FUENTE, 15));
        super.setPadding(new Insets(5));
        super.setTextFill(Color.BLACK);
        super.setAlignment(Pos.CENTER);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.AMARILLO, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(1)));

        super.setBackground(unFondo);
        //super.setOnAction(new ControladorModificador(this,multiplicador));
        super.setOnMouseEntered(new ControladorActivarBoton(this, Estilos.AMARILLO));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.AMARILLO));
    }
}
