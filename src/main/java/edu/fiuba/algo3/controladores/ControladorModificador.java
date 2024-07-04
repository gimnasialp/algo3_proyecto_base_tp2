package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorModificador implements EventHandler<ActionEvent> {
    private Modificador modificador;
    private AlgoHoot algoHoot;


    public ControladorModificador(Modificador modificador, AlgoHoot algoHoot) {
        this.modificador = modificador;
        this.algoHoot = algoHoot;
    }

    @Override
    public void handle(ActionEvent event) {
        algoHoot.obtenerPartidaActiva().obtenerJugadorActivo().obtenerModificadoresDisponibles().remove(modificador);
        algoHoot.obtenerPartidaActiva().activaModificador(modificador, algoHoot.obtenerPartidaActiva().obtenerJugadorActivo());

    }
}
