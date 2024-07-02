package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificador.*;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.vista.botones.BotonMultiplicador;
import edu.fiuba.algo3.vista.mensajes.MensajeSinExclusividad;
import edu.fiuba.algo3.vista.mensajes.MensajeSinMultiplicadores;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class CajaModificadores extends HBox {


    private static final int ESPACIO_ENTRE_MULTIPLICADORES = 40;

    private MultiplicarPorDos multiplicadorPorDos;
    private MultiplicarPorTres multiplicadorPorTres;
    private AnuladorDePuntaje anuladorDePuntaje;
    private ExclusividadDePuntaje exclusividadDePuntaje;

    private PreguntaOrderedChoice preguntaOrderedChoice;
    private PreguntaGroupChoice preguntaGroupChoice;
    private PreguntaMultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad;
    private PreguntaVerdaderoFalsoConPenalidad preguntaVerdaderoFalsoConPenalidad;
    private PreguntaMultipleChoiceParcial preguntaMultipleChoiceParcial;
    private PreguntaMultipleChoiceClasico preguntaMultipleChoiceClasico;
    private PreguntaVerdaderoFalsoClasico preguntaVerdaderoFalsoClasico;

    public CajaModificadores(AlgoHoot algoHoot) {
        super(ESPACIO_ENTRE_MULTIPLICADORES);
        super.setAlignment(Pos.CENTER);

        Pregunta pregunta = algoHoot.obtenerPartidaActiva().obtenerPreguntaActual();
        Jugador jugador = algoHoot.obtenerPartidaActiva().obtenerJugadorActivo();

        // Verificar si el jugador tiene multiplicadores disponibles
        if (esPreguntaConPenalidad(pregunta)) {
            List<Multiplicador> multiplicadores = jugador.obtenerMultiplicadoresDisponibles();
            if (multiplicadores.isEmpty()) {
                //crearBotonesMultiplicador(multiplicadores);
                //crearBotonAnulador(jugador);
            } else {
                mostrarTextoSinMultiplicadores();
            }
        }

        // Verificar si el jugador tiene exclusividades disponibles
            /*if (esPreguntaClasica(pregunta)) {
                crearBotonExclusividad(jugador);
            }*/
    }

    private boolean esPreguntaConPenalidad(Pregunta pregunta) {
        return pregunta.equals(preguntaMultipleChoiceConPenalidad) ||
                pregunta.equals(preguntaVerdaderoFalsoConPenalidad);
    }

    private boolean esPreguntaClasica(Pregunta pregunta) {
        return pregunta.equals(preguntaMultipleChoiceClasico) ||
                pregunta.equals(preguntaVerdaderoFalsoClasico) ||
                pregunta.equals(preguntaMultipleChoiceParcial) ||
                pregunta.equals(preguntaOrderedChoice) ||
                pregunta.equals(preguntaGroupChoice);
    }

    /*
            private void crearBotonAnulador(Jugador jugador) {
                if (!jugador.anuladorFueUtilizado(anuladorDePuntaje)) {
                    BotonAnulador botonAnulador = new BotonAnulador(anuladorDePuntaje);
                    super.getChildren().add(botonAnulador);
                } else {
                    TextoSinAnulador textoSinAnulador = new TextoSinAnulador();
                    super.getChildren().add(textoSinAnulador);
                }
            }

            private void crearBotonExclusividad(Jugador jugador) {
                List<ExclusividadDePuntaje> exclusividades = jugador.obtenerExclusividadesDisponibles();
                if (exclusividades.isEmpty()) {
                    MensajeSinExclusividad mensajeSinExclusividad = new MensajeSinExclusividad();
                    super.getChildren().add(mensajeSinExclusividad);
                } else {
                    BotonExclusividad botonExclusividad = new BotonExclusividad(exclusividades);
                    super.getChildren().add(botonExclusividad);
                }
            }
    *//*
    private void crearBotonesMultiplicador(List<Multiplicador> multiplicadores) {
        for (Multiplicador multiplicador : multiplicadores) {
            BotonMultiplicador botonMultiplicador = new BotonMultiplicador(multiplicador);
            super.getChildren().add(botonMultiplicador);
        }
    }*/

    private void mostrarTextoSinMultiplicadores() {
        MensajeSinMultiplicadores mensajeSinMultiplicadores = new MensajeSinMultiplicadores();
        super.getChildren().add(mensajeSinMultiplicadores);
    }
}


