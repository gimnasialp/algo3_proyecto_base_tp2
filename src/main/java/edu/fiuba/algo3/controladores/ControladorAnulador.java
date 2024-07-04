package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.Modificador.Modificador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAnulador implements EventHandler<ActionEvent> {

    private AlgoHoot algoHoot;
    private AnuladorDePuntaje anuladorDePuntaje;

    public ControladorAnulador(Modificador anulador, AlgoHoot algoHoot) {
        this.algoHoot = algoHoot;
        this.anuladorDePuntaje = (AnuladorDePuntaje) anulador;
    }

    @Override
    public void handle(ActionEvent event) {
        algoHoot.obtenerPartidaActiva().obtenerJugadorActivo().obtenerModificadoresDisponibles().remove(anuladorDePuntaje);
        algoHoot.obtenerPartidaActiva().activaModificador(anuladorDePuntaje, algoHoot.obtenerPartidaActiva().obtenerJugadorActivo());
    }
}

