package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.*;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CajaComodinesJugador extends HBox {

    private static int ESPACIADO_BONUS = 5;

    public CajaComodinesJugador(Jugador jugador) {
        super(ESPACIADO_BONUS);
        super.setAlignment(Pos.CENTER);
        List<Multiplicador> multiplicadores =  jugador.obtenerMultiplicadoresDisponibles();
        crearCirculosMultiplicadores(multiplicadores);
        List<Modificador> modificadores = jugador.obtenerModificadoresDisponibles();
        crearCirculosModificador(modificadores);
    }

    private void crearCirculosMultiplicadores(List<Multiplicador> multiplicadores){
        for (Multiplicador multiplicador:multiplicadores) {
            super.getChildren().add(new CirculoMultiplicador(multiplicador));
        }
    }

    private void crearCirculosModificador(List<Modificador> modificadores){
        for (Modificador modificador:modificadores) {
            super.getChildren().add(new CirculoModificador(modificador));
        }

    }


}
