package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerOrderedChoice;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class BotonEnviarRespuestaOrderedChoice extends Button {

    public BotonEnviarRespuestaOrderedChoice(ControladorEnviarOrderedChoice controlador, VBox cajaOpciones) {
        /*super.setText("Enviar respuesta");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.BLACK);
        ArrayList<SpinnerOrderedChoice> opcionesOrden = new ArrayList<>();
        for (Node opcion : cajaOpciones.getChildren()) {
            if (opcion instanceof SpinnerOrderedChoice) {
                opcionesOrden.add((SpinnerOrderedChoice) opcion);
            }
        }
        */
        super.setText("Enviar respuesta");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.BLACK);
        //Recibo la VBox de opciones dentro de pregunta
        ObservableList<Node> opciones = cajaOpciones.getChildren();
        ArrayList<SpinnerOrderedChoice> opcionesOrden = new ArrayList<>();
        for (Node opcion : opciones) {
            opcionesOrden.add((SpinnerOrderedChoice) opcion);
        }
        System.out.println("esto es dentro del boton enviar respuesta" + opcionesOrden);
        controlador.agregarOpcionesSeleccionadas(opcionesOrden);
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.VERDE, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(0)));
        super.setBackground(unFondo);

        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this, Estilos.VERDE));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.VERDE));
    }

}
