package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VP.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GestorVistasPreguntas {

    public static StackPane CrearVistaDePregunta(AlgoHoot algoHoot, Stage stage, PantallaPrincipal contenedorPrincipal) {
        StackPane vistaPregunta = new StackPane();

        if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaVerdaderoFalsoClasico ||
                algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaVerdaderoFalsoConPenalidad) {
            vistaPregunta = new VistaVF(algoHoot, stage, contenedorPrincipal);

        } else if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaOrderedChoice) {
            vistaPregunta = new VistaOrderedChoice(algoHoot, stage, contenedorPrincipal);

        } else if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaGroupChoice) {
            //vistaPregunta = new VistaGroupChoice(algoHoot, stage, contenedorPrincipal);

        } else if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaMultipleChoiceClasico) {
            vistaPregunta = new VistaMultipleChoiceClasico(algoHoot, stage, contenedorPrincipal);

        } else if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaMultipleChoiceConPenalidad) {
            vistaPregunta = new VistaMultipleChoicePenalidad(algoHoot, stage, contenedorPrincipal);

        } else if (algoHoot.obtenerPartidaActiva().obtenerPreguntaActual() instanceof PreguntaMultipleChoiceParcial) {
            vistaPregunta = new VistaMultipleChoiceParcial(algoHoot, stage, contenedorPrincipal);

        }

        return vistaPregunta;
    }
}


