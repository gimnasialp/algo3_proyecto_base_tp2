package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Estilos;
import edu.fiuba.algo3.controladores.ControladorActivarBoton;
import edu.fiuba.algo3.controladores.ControladorDesactivarBoton;
import edu.fiuba.algo3.vista.botones.Spinners.SpinnerGroupChoice;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
/*
public class BotonEnviarRespuestaGroupChoice extends Button {

    public BotonEnviarRespuestaGroupChoice(ControladorEnviarGroupChoice controlador, VBox cajaOpciones) {

        super.setText("Enviar respuesta");
        super.setFont(Font.font(Estilos.FUENTE, 30));
        super.setPadding(new Insets(10));
        super.setTextFill(Color.BLACK);
        //Recibo la VBox de opciones dentro de pregunta
        ObservableList<Node> opcionesGrupo = cajaOpciones.getChildren();
        ArrayList<SpinnerGroupChoice> spinnersGrupo = new ArrayList<>();
        for (Node opcion : opcionesGrupo) {
            spinnersGrupo.add((SpinnerGroupChoice) opcion);
        }
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Estilos.BORDE_CURVO, Estilos.GROSOR_BORDE)));
        Background unFondo = new Background(new BackgroundFill(Color.web(Estilos.VERDE, Estilos.ALPHA_BOTON_INACTIVO), Estilos.BORDE_CURVO, new Insets(0)));
        super.setBackground(unFondo);

        controlador.agregarSpinnersGrupo(spinnersGrupo);
        super.setOnAction(controlador);
        super.setOnMouseEntered(new ControladorActivarBoton(this, Estilos.VERDE));
        super.setOnMouseExited(new ControladorDesactivarBoton(this, Estilos.VERDE));
    }
}*/
