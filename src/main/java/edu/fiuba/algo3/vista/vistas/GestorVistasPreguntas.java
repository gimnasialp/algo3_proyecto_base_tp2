package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.Partida.Partida;
import edu.fiuba.algo3.modelo.Pregunta.*;
import edu.fiuba.algo3.vista.PantallaPrincipal;
import edu.fiuba.algo3.vista.vistas.VP.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*public class GestorVistasPreguntas {
    private static PreguntaOrderedChoice preguntaOrderedChoice;
    private static PreguntaGroupChoice preguntaGroupChoice;
    private static PreguntaMultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad;
    private static PreguntaVerdaderoFalsoConPenalidad preguntaVerdaderoFalsoConPenalidad;
    private static PreguntaMultipleChoiceParcial preguntaMultipleChoiceParcial;
    private static PreguntaMultipleChoiceClasico preguntaMultipleChoiceClasico;
    private static PreguntaVerdaderoFalsoClasico preguntaVerdaderoFalsoClasico;

    public static StackPane CrearVistaDePregunta(Partida partidaActual, Stage stage, PantallaPrincipal contenedorPrincipal) {
        StackPane vistaPregunta = new StackPane();
        if (partidaActual.obtenerPreguntaActual().getClass() == PreguntaVerdaderoFalsoClasico.class ) {
            vistaPregunta = new VistaVFClasico(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().getClass() == PreguntaOrderedChoice.class) {
            vistaPregunta = new VistaVFPenalidad(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().getClass() == PreguntaOrderedChoice.class) {
            vistaPregunta = new VistaGroupChoice(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().getClass() == PreguntaOrderedChoice.class) {
            vistaPregunta = new VistaOrderedChoice(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().equals(preguntaMultipleChoiceClasico)) {
            vistaPregunta = new VistaMultipleChoiceClasico(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().equals(preguntaMultipleChoiceConPenalidad)) {
            vistaPregunta = new VistaMultipleChoiceParcial(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual().equals(preguntaMultipleChoiceConPenalidad)) {
            vistaPregunta = new VistaMultipleChoicePenalidad(partidaActual, stage, contenedorPrincipal);
        }
        return vistaPregunta;
    }

}
*/
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class GestorVistasPreguntas {
    private static PreguntaOrderedChoice preguntaOrderedChoice;
    private static PreguntaGroupChoice preguntaGroupChoice;
    private static PreguntaMultipleChoiceConPenalidad preguntaMultipleChoiceConPenalidad;
    private static PreguntaVerdaderoFalsoConPenalidad preguntaVerdaderoFalsoConPenalidad;
    private static PreguntaMultipleChoiceParcial preguntaMultipleChoiceParcial;
    private static PreguntaMultipleChoiceClasico preguntaMultipleChoiceClasico;
    private static PreguntaVerdaderoFalsoClasico preguntaVerdaderoFalsoClasico;

    public static StackPane CrearVistaDePregunta(Partida partidaActual, Stage stage, PantallaPrincipal contenedorPrincipal) {
        StackPane vistaPregunta = new StackPane();

        if (partidaActual.obtenerPreguntaActual() instanceof PreguntaVerdaderoFalsoClasico) {
            vistaPregunta = new VistaVFClasico(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaOrderedChoice) {
            vistaPregunta = new VistaOrderedChoice(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaGroupChoice) {
            vistaPregunta = new VistaGroupChoice(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaMultipleChoiceClasico) {
            vistaPregunta = new VistaMultipleChoiceClasico(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaMultipleChoiceConPenalidad) {
            vistaPregunta = new VistaMultipleChoicePenalidad(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaMultipleChoiceParcial) {
            vistaPregunta = new VistaMultipleChoiceParcial(partidaActual, stage, contenedorPrincipal);

        } else if (partidaActual.obtenerPreguntaActual() instanceof PreguntaVerdaderoFalsoConPenalidad) {
            vistaPregunta = new VistaVFPenalidad(partidaActual, stage, contenedorPrincipal);
        }

        return vistaPregunta;
    }
}


