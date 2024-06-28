package edu.fiuba.algo3.controladores.Iniciales;

import edu.fiuba.algo3.controladores.ReproductorMusica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMusica implements EventHandler<ActionEvent> {

    private String direccion;
    private ReproductorMusica reproductor;
    public ControladorMusica(String direccionMusica, ReproductorMusica unReproductor) {
        direccion = direccionMusica;
        reproductor = unReproductor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproductor.escucharTema(direccion);
    }
}