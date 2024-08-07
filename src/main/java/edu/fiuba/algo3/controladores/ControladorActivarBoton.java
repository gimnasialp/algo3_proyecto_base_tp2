package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Estilos;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ControladorActivarBoton implements EventHandler<MouseEvent> {
    private Button boton;
    private String botonColor;

    public ControladorActivarBoton(Button boton, String botonColor) {
        this.boton = boton;
        this.botonColor = botonColor;

    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        boton.setBackground(new Background(new BackgroundFill(Color.web(botonColor, Estilos.ALPHA_BOTON_ACTIVO), Estilos.BORDE_CURVO, new Insets(1))));
    }

}
