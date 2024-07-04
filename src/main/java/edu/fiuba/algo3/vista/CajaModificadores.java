package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.vista.botones.*;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CajaModificadores extends HBox {


    private static final int ESPACIO_ENTRE_MULTIPLICADORES = 40;
    private Partida partida;
    private ArrayList<Modificador> modificadores;
    private ArrayList<Multiplicador> multiplicadores;

    public CajaModificadores(AlgoHoot algoHoot) {
        super(ESPACIO_ENTRE_MULTIPLICADORES);
        super.setAlignment(Pos.CENTER);
        this.partida = algoHoot.obtenerPartidaActiva();

        this.modificadores = new ArrayList<>(Arrays.asList(new ExclusividadDePuntaje()));
        this.multiplicadores = new ArrayList(Arrays.asList(new MultiplicarPorDos(), new MultiplicarPorTres()));
        List<Multiplicador> multiplicadoresJugadorActual = partida.obtenerJugadorActivo().obtenerMultiplicadoresDisponibles();
        List<Modificador> modificadoresJugadorActual = partida.obtenerJugadorActivo().obtenerModificadoresDisponibles();

        if (esPreguntaConPenalidad(partida.obtenerPreguntaActual())) {
            crearBotonesMultiplicador(multiplicadoresJugadorActual, algoHoot);
        } else if (esPreguntaSinPenalidad(partida.obtenerPreguntaActual())) {
            crearBotonesModificador(modificadoresJugadorActual, algoHoot);
        }

        // Siempre agregar el AnuladorDePuntaje si está disponible
        if (modificadoresJugadorActual.contains(new AnuladorDePuntaje())) {
            super.getChildren().add(crearBotonAnulador(new AnuladorDePuntaje(), algoHoot));
        }

    }

    private boolean esPreguntaConPenalidad(Pregunta pregunta) {
        return (pregunta instanceof PreguntaVerdaderoFalsoConPenalidad ||
                pregunta instanceof PreguntaMultipleChoiceConPenalidad);
    }

    private boolean esPreguntaSinPenalidad(Pregunta pregunta) {
        return (pregunta instanceof PreguntaVerdaderoFalsoClasico ||
                pregunta instanceof PreguntaMultipleChoiceClasico ||
                pregunta instanceof PreguntaMultipleChoiceParcial ||
                pregunta instanceof PreguntaOrderedChoice ||
                pregunta instanceof PreguntaGroupChoice);
    }


    private void crearBotonesMultiplicador(List<Multiplicador> multiplicadoresJugadorActual,AlgoHoot algoHoot) {
        for (Multiplicador multiplicador : this.multiplicadores) {
            if (multiplicadoresJugadorActual.contains(multiplicador)) {
                super.getChildren().add(crearBotonMultiplicador(multiplicador,algoHoot));
            } else {
                super.getChildren().add(crearBotonSinMultiplicador(multiplicador));

            }
        }
    }
    private void crearBotonesModificador(List<Modificador> modificadoresJugadorActual,AlgoHoot algoHoot) {
        for (Modificador modificador : this.modificadores) {
            if (modificadoresJugadorActual.contains(modificador)) {
                super.getChildren().add(crearBotonModificador(modificador,algoHoot));
            } else {
                super.getChildren().add(crearBotonSinModificador(modificador));

            }
        }
    }
    private void crearBotonesAnulador(List<Modificador> modificadoresJugadorActual,AlgoHoot algoHoot) {
        for (Modificador modificador : this.modificadores) {
            if (modificadoresJugadorActual.contains(modificador)) {
                super.getChildren().add(crearBotonAnulador(new AnuladorDePuntaje(),algoHoot));
            } else {
                super.getChildren().add(crearBotonSinAnulador());

            }
        }
    }

    private VBox crearBotonMultiplicador(Multiplicador multiplicador,AlgoHoot algoHoot) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonMultiplicador botonMultiplicador = new BotonMultiplicador(multiplicador,algoHoot);
        cajaBotonModificador.getChildren().add(botonMultiplicador);
        return cajaBotonModificador;
    }

    private VBox crearBotonModificador(Modificador modificador,AlgoHoot algoHoot) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonExclusividad botonExclusividad = new BotonExclusividad(modificador,algoHoot);
        cajaBotonModificador.getChildren().add(botonExclusividad);
        return cajaBotonModificador;
    }

    private VBox crearBotonAnulador(AnuladorDePuntaje anulador,AlgoHoot algoHoot) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonAnulador botonAnulador = new BotonAnulador(anulador,algoHoot);
        cajaBotonModificador.getChildren().add(botonAnulador);
        return cajaBotonModificador;
    }

    private VBox crearBotonSinMultiplicador(Multiplicador multiplicador) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonSinMultiplicador botonMultiplicador = new BotonSinMultiplicador(multiplicador);
        cajaBotonModificador.getChildren().add(botonMultiplicador);
        return cajaBotonModificador;
    }

    private VBox crearBotonSinModificador(Modificador modificador) {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonSinModificador botonExclusividad = new BotonSinModificador(modificador);
        cajaBotonModificador.getChildren().add(botonExclusividad);
        return cajaBotonModificador;
    }

    private VBox crearBotonSinAnulador() {
        VBox cajaBotonModificador = new VBox(0);
        cajaBotonModificador.setAlignment(Pos.BOTTOM_CENTER);
        BotonSinAnulador botonAnulador = new BotonSinAnulador();
        cajaBotonModificador.getChildren().add(botonAnulador);
        return cajaBotonModificador;
    }


}



