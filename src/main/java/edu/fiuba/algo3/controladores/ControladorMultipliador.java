package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.Multiplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMultipliador implements EventHandler<ActionEvent> {

    private AlgoHoot algoHoot;
    private Multiplicador multiplicador;

    public ControladorMultipliador(Multiplicador multiplicador, AlgoHoot algoHoot) {

        this.algoHoot = algoHoot;
        this.multiplicador = multiplicador;
    }

    @Override
    public void handle(ActionEvent event) {
        algoHoot.obtenerPartidaActiva().obtenerJugadorActivo().obtenerMultiplicadoresDisponibles().remove(multiplicador);
        algoHoot.obtenerPartidaActiva().activaMultiplicador(multiplicador, algoHoot.obtenerPartidaActiva().obtenerJugadorActivo());

    }
}
